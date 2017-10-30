package com.zx;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zx.locker.DistributedLocker;
import com.zx.worker.AquiredLockWorker;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedLockTests {

    @Autowired
    private DistributedLocker distributedLocker;
    
    @Test
    public void testRedLock() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch( 1 );
        CountDownLatch doneSignal = new CountDownLatch( 5 );
        
        for (int i = 0; i < 5; i++){ //create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        startSignal.countDown(); //let all threads proceed
        doneSignal.await();
        System.out.println( "All processors done. Shutdown connection! " );
    }
    
    class Worker implements Runnable{
        
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;
        
        public Worker( CountDownLatch startSignal, CountDownLatch doneSignal ) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                distributedLocker.lock( "test", new AquiredLockWorker<Object>() {

                    @Override
                    public Object invokeAfterLockAquire() {
                        doTask();
                        return null;
                    }
                } );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
        
        private void doTask(){
            String currentThreadName = Thread.currentThread().getName();
            System.out.println( currentThreadName + "start" );
            Random random = new Random();
            int randomInt = random.nextInt( 200 );
            System.out.println( currentThreadName + "sleep" + randomInt +"millis" );
            try {
                Thread.sleep( randomInt );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
            System.out.println( currentThreadName + "end" );
            doneSignal.countDown();
        }
    }
}

package com.zx;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zx.background.service.AsyncMsgFutureService;
import com.zx.background.service.AsyncMsgService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AsyncMsgTest {
    
    @Autowired
    private AsyncMsgService asyncMsgService;
    
    @Autowired
    private AsyncMsgFutureService asyncMsgFutureService;
    
    /**
     * @author zhongxin
     * @date 2017年8月29日
     * @description 异步任务执行开始测试方法就执行完了，并且执行成功，即使异步任务出错，也不会影响测试方法
     */
	@Test
	public void addUserTest(){
	   asyncMsgService.addUserA();
	   asyncMsgService.addUserB();
	}
	
	@Test
	public void sendTest() throws InterruptedException{
	    long startTime = System.currentTimeMillis();
	    
	    Future<String> futureA = asyncMsgFutureService.sendA();
	    Future<String> futureB = asyncMsgFutureService.SendB();
	    
	    while(true){
	        if (futureA.isDone() && futureB.isDone()){
	            break;
	        }
	    }
	    
	    long endTime = System.currentTimeMillis();
	    
	    System.out.println( "总耗时：" + ( endTime - startTime ) );
	}
}

package com.zx.locker.impl;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zx.connect.RedissonConnector;
import com.zx.exception.UnableToAquireLockException;
import com.zx.locker.DistributedLocker;
import com.zx.worker.AquiredLockWorker;

/**
 * @author zhongxin
 * @date 2017年9月20日
 * @description 管理锁的实现类
 */
@Component
public class DistributedLockerImpl implements DistributedLocker {
    
    private final static String LOCKER_PREFIX = "lock:";
    
    @Autowired
    private RedissonConnector redissonConnector;

    @Override
    public <T> T lock( String lockerName, AquiredLockWorker<T> worker ) throws InterruptedException {
        return lock(lockerName, worker, 100);
    }

    @Override
    public <T> T lock( String lockerName, AquiredLockWorker<T> worker, int lockTime ) throws InterruptedException {
        RedissonClient redissonClient = redissonConnector.getClient();
        RLock rLock = redissonClient.getLock( LOCKER_PREFIX + lockerName);
        boolean lockSuccess = rLock.tryLock( 100, lockTime, TimeUnit.SECONDS );
        if (lockSuccess){
            try {
                return worker.invokeAfterLockAquire();
            } finally {
                rLock.unlock();
            }
        }
        throw new UnableToAquireLockException();
    }

}

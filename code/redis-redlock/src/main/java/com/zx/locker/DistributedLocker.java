package com.zx.locker;

import com.zx.worker.AquiredLockWorker;

/**
 * @author zhongxin
 * @date 2017年9月20日
 * @description 获取锁管理类
 */
public interface DistributedLocker {
    
    /**
     * @author zhongxin
     * @date 2017年9月20日
     * @description 获取锁
     * @param resourceName 锁名称
     * @param worker 获取锁后的处理业务逻辑
     * @return 处理完具体的业务逻辑要返回的数据
     * @throws InterruptedException 
     */
    <T> T lock(String lockerName,AquiredLockWorker<T> worker) throws InterruptedException; 
    
    <T> T lock(String lockerName,AquiredLockWorker<T> worker, int lockTime) throws InterruptedException;
}

package com.zx.worker;

/**
 * @author zhongxin
 * @date 2017年9月20日
 * @description 获取锁后需要处理的逻辑
 * @param <T>
 */
public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire();
}

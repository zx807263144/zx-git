package com.zx.background.service;

/**
 * @author zhongxin
 * @date 2017年8月30日
 * @description 异步方法service，该service不需要对异步方法执行结果进行操作，只需要异步方法执行了就可以了
 */
public interface AsyncMsgService {
    
    void addUserA();
    
    void addUserB();
}

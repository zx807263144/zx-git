package com.zx.background.service;

import java.util.concurrent.Future;

/**
 * @author zhongxin
 * @date 2017年8月30日
 * @description 该service要对异步方法执行结果进行操作，所以使用future-listener实现
 */
public interface AsyncMsgFutureService {
    
    Future<String> sendA() throws InterruptedException;
    
    Future<String> SendB() throws InterruptedException;
}

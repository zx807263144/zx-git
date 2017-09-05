package com.zx.background.service.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.zx.background.service.AsyncMsgFutureService;

@Service
public class AsyncMsgFutureServiceImpl implements AsyncMsgFutureService {

    @Async
    @Override
    public Future<String> sendA() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        System.out.println( "sendA开始时间："+startTime );
        System.out.println( "sendA" );
        Thread.sleep( 2000 );
        Long endTime = System.currentTimeMillis();
        System.out.println( "sendA结束时间："+endTime );
        System.out.println( "sendA耗时："+( endTime - startTime ) );
        return new AsyncResult<String>( "success" );
    }

    @Async
    @Override
    public Future<String> SendB() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        System.out.println( "sendB开始时间："+startTime );
        System.out.println( "sendB" );
        Thread.sleep( 2000 );
        Long endTime = System.currentTimeMillis();
        System.out.println( "sendB结束时间："+endTime );
        System.out.println( "sendB耗时："+( endTime - startTime ) );
        return new AsyncResult<String>( "success" );
    }

}

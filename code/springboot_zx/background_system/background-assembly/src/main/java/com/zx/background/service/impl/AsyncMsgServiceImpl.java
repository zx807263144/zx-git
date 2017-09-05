package com.zx.background.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.zx.background.dao.UserDao;
import com.zx.background.model.UserModel;
import com.zx.background.service.AsyncMsgService;

/**
 * @author zhongxin
 * @date 2017年8月30日
 * @description 异步执行发送消息服务
 */
@Service
public class AsyncMsgServiceImpl implements AsyncMsgService {
    
    @Autowired
    private UserDao userDao;
    
    @Async
    @Override
    public void addUserA(){
        UserModel userModel = new UserModel();
        userModel.setNickName( "异步任务A" );
        userModel.setRealName( "异步任务A" );
        userModel.setPassword( "00c66aaf5f2c3f49946f15c1ad2ea0d3" );
        userDao.create( userModel );
    }

    @Async
    @Override
    public void addUserB() {
        UserModel userModel = new UserModel();
        userModel.setNickName( "异步任务B" );
        userModel.setRealName( "异步任务B" );
        userModel.setPassword( "00c66aaf5f2c3f49946f15c1ad2ea0d3" );
        userDao.create( userModel );
    }

}

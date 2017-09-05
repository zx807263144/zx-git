package com.zx.background.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.background.dao.MongoUserDao;
import com.zx.background.dao.RedisBaseDao;
import com.zx.background.dao.UserDao;
import com.zx.background.model.UserModel;
import com.zx.background.service.UserService;

/**
 * @author zhongxin
 * @date 2017年8月16日
 * @description userService实现类
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
//    @Autowired
//    private RedisBaseDao redisBaseDao;
    
//    @Autowired
//    private MongoUserDao mongoUserDao;

    @Override
    public int delete( Long id ) {
        return userDao.delete( id );
    }

    @Override
    @Transactional
    public int create( UserModel record ) {
        //影响的行数
        int influenceNum = userDao.create( record );
        
//        redisBaseDao.addValue( "user"+record.getId(), record.getRealName() );
//        System.out.println( redisBaseDao.getValue( "user1" ) );
//        mongoUserDao.create( record );
//        if (record.getId() > 12){
//            throw new RuntimeException( "测试声明事务管理" );
//        }
        return influenceNum;
    }

    @Override
    public UserModel find( Long id ) {
//        System.out.println( "mongodb中userModel数据：" + mongoUserDao.find( id ) );
        return userDao.find( id );
    }

    @Override
    public int update( UserModel record ) {
//        mongoUserDao.update( record );
        return userDao.update( record );
    }

    @Override
//    @Cacheable(value="userList")
    public List<UserModel> findUserList() {
//        System.out.println( "mongodb中userlist："+mongoUserDao.findUserList() );
        System.out.println( "数据库中获取userList" );
        return userDao.findUserList();
    }

}

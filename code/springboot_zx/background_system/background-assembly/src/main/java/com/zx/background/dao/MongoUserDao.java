package com.zx.background.dao;

import java.util.List;

import com.zx.background.model.UserModel;

/**
 * @author zhongxin
 * @date 2017年8月21日
 * @description mongoDB对应的UserModel的dao操作
 */
public interface MongoUserDao {

    void delete(Long id);

    void create(UserModel record);

    UserModel find(Long id);

    void update(UserModel record);
    
    /**
     * @author zhongxin
     * @date 2017年8月16日
     * @description 查询用户集合
     * @return
     */
    List<UserModel> findUserList();
}
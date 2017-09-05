package com.zx.background.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zx.background.model.UserModel;

/**
 * @author zhongxin
 * @date 2017年8月16日
 * @description 用户dao
 */
@Mapper
public interface UserDao {

    int delete(Long id);

    int create(UserModel record);

    UserModel find(Long id);

    int update(UserModel record);
    
    /**
     * @author zhongxin
     * @date 2017年8月16日
     * @description 查询用户集合
     * @return
     */
    List<UserModel> findUserList();
}
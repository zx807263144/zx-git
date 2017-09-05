package com.zx.background.dao;

import com.zx.background.model.UserModel;
import com.zx.background.model.UserModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    long countByExample(UserModelExample example);

    int deleteByExample(UserModelExample example);

    int delete(Long id);

    int create(UserModel record);

    int insertSelective(UserModel record);

    List<UserModel> selectByExample(UserModelExample example);

    UserModel find(Long id);

    int updateByExampleSelective(@Param("record") UserModel record, @Param("example") UserModelExample example);

    int updateByExample(@Param("record") UserModel record, @Param("example") UserModelExample example);

    int updateProperties(UserModel record);

    int update(UserModel record);
}
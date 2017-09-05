package com.zx.background.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import com.zx.background.dao.UserDao;
import com.zx.background.model.UserModel;

/**
 * @author zhongxin
 * @date 2017年8月16日
 * @description 用户dao实现类,使用JdbcTemplate操作数据
 */
//@Repository
public class JdbcTemplateUserDaoImpl implements UserDao {
    
//    @Autowired
//    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate masterJdbcTemplate;
    
//    @Autowired
//    @Qualifier("slaveJdbcTemplate")
    private JdbcTemplate slaveJdbcTemplate;

    @Override
    public int delete( Long id ) {
        return masterJdbcTemplate.update( "DELETE FROM zx_user WHERE id = ?", id );
    }

    @Override
    public int create( UserModel record ) {
        slaveJdbcTemplate.update( "INSERT INTO zx_user (real_name, nick_name, password, gmt_create_time, gmt_modify_time) VALUES ( ?, ?, ?, NOW(), NOW() )",
                record.getRealName(),record.getNickName(),record.getPassword() );
        
        return masterJdbcTemplate.update( "INSERT INTO zx_user (real_name, nick_name, password, gmt_create_time, gmt_modify_time) VALUES ( ?, ?, ?, NOW(), NOW() )",
                   record.getRealName(),record.getNickName(),record.getPassword() );
    }

    @Override
    public UserModel find( Long id ) {
        List<UserModel> userModelList =  masterJdbcTemplate.query( "SELECT * FROM zx_user WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<UserModel>( UserModel.class ) );
        UserModel userModel = null;
        if (!CollectionUtils.isEmpty( userModelList )){
            userModel = userModelList.get( 0 );
        }
        return userModel;
    }

    @Override
    public int update( UserModel record ) {
        
        return masterJdbcTemplate.update( "UPDATE zx_user SET real_name = ?, nick_name = ? WHERE id = ?", 
                   record.getRealName(),record.getNickName(),record.getId());
    }

    @Override
    public List<UserModel> findUserList() {
        List<UserModel> userModelList =  masterJdbcTemplate.query( "SELECT * FROM zx_user", new Object[]{}, new BeanPropertyRowMapper<UserModel>( UserModel.class ) );
        return userModelList;
    }

}

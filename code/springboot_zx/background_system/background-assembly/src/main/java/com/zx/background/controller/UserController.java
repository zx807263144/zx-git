package com.zx.background.controller;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.background.model.UserModel;
import com.zx.background.service.UserService;

/**
 * @author zhongxin
 * @date 2017年8月16日
 * @description user控制层
 */
@RequestMapping("/userController")
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 查询用户集合
     * @author zhongxin
     * @date 2017年8月16日
     * @description
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public List<UserModel> userLists(){
        return userService.findUserList();
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月16日
     * @description 用户详情
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public UserModel userDetail(@PathVariable Long userId){
        UserModel userModel = userService.find( userId );
        
        if (userModel == null){
            throw new IllegalArgumentException( "当前用户不存在" );
        }
        return userModel;
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月16日
     * @description 新增用户
     * @param userModel
     */
    @RequestMapping(method = RequestMethod.POST)
    public void create (@RequestBody UserModel userModel){
        userModel.setPassword( DigestUtils.md5Hex( userModel.getPassword() ) );
        userService.create( userModel );
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月16日
     * @description 更新用户
     * @param userModel
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody UserModel userModel){
        userService.update( userModel );
    }
    
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId){
        userService.delete( userId );
    }
    
}

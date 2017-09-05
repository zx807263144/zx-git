package com.zx.background.model;

/**
 * @author zhongxin
 * @date 2017年8月16日
 * @description 用户model
 */
//@Document(collection="user")
public class UserModel extends BaseModel {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户真实姓名.
     */
    private String realName;

    /**
     * 用户昵称.
     */
    private String nickName;

    /**
     * 密码.
     */
    private String password;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
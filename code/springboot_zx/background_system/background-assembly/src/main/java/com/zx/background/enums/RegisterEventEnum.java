package com.zx.background.enums;


/**
 * @author zhongxin
 * @date 2017年8月30日
 * @description 注册事件枚举
 */
public enum RegisterEventEnum {
    
    CONNECT("CONNECT","连接"),
    
    REGISTER("REGISTER","注册"),
    
    REGISTER_SUCCESS("REGISTER_SUCCESS","注册成功"),
    
    REGISTER_FAIL("REGISTER_FAIL","注册失败"),
    
    UN_REGISTER("UN_REGISTER","注销");
    
    private final String value;
    
    private final String displayName;

    private RegisterEventEnum( String value, String displayName ) {
        this.value = value;
        this.displayName = displayName;
    }
    
    public String getValue(){
        return this.value;
    }
    
    public String getDisplayName(){
        return this.displayName;
    }
}

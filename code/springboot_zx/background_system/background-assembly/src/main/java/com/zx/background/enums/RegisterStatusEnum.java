package com.zx.background.enums;


/**
 * @author zhongxin
 * @date 2017年8月30日
 * @description 注册状态枚举
 */
public enum RegisterStatusEnum {
    
    UNCONNECTED("UNCONNECTED","未连接"),
    
    CONNECTED("CONNECTED","已连接"),
    
    REGISTERING("REGISTERING","注册中"),
    
    REGISTERED("REGISTERED","已注册");
    
    private final String value;
    
    private final String displayName;

    private RegisterStatusEnum( String value, String displayName ) {
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

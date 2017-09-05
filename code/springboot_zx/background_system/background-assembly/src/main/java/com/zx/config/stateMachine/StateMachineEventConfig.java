package com.zx.config.stateMachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author zhongxin
 * @date 2017年8月30日
 * @description 状态监听器，Spring StateMachine 提供了注解配置实现方式，所有 StateMachineListener 接口中定义的事件都能通过注解的方式来进行配置实现
 */
@WithStateMachine
public class StateMachineEventConfig {
    
    
    @OnTransition(source="UNCONNECTED",target="CONNECTED")
    public void connect(){
        System.out.println( "////////////////" );
        System.out.println( "连接事件，未连接->已连接" );
        System.out.println( "////////////////" );
    }
    
    @OnTransition(source="CONNECTED",target="REGISTERING")
    public void register(){
        System.out.println( "////////////////" );
        System.out.println( "注册事件，已连接->注册中" );
        System.out.println( "////////////////" );
    }
    
    @OnTransition(source="REGISTERING",target="REGISTERED")
    public void registerSuccess(){
        System.out.println( "////////////////" );
        System.out.println( "注册成功事件，注册中->已注册" );
        System.out.println( "////////////////" );
    }
    
    @OnTransition(source="REGISTERED",target="UNCONNECTED")
    public void unRegister(){
        System.out.println( "////////////////" );
        System.out.println( "注销事件，已注册->未连接" );
        System.out.println( "////////////////" );
    }
}

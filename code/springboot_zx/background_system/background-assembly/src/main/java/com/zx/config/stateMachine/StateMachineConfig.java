package com.zx.config.stateMachine;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.zx.background.enums.RegisterEventEnum;
import com.zx.background.enums.RegisterStatusEnum;

/**
 * @author zhongxin
 * @date 2017年8月30日
 * @description 状态机配置
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<RegisterStatusEnum, RegisterEventEnum> {
    
    /**
     * 初始化状态机状态,我们需要初始化状态机的状态
     */
    @Override
    public void configure( StateMachineStateConfigurer<RegisterStatusEnum, RegisterEventEnum> states ) throws Exception {
        states.withStates()
            .initial( RegisterStatusEnum.UNCONNECTED ) //定义初始状态是未连接状态
            .states( EnumSet.allOf( RegisterStatusEnum.class ) ); //定义状态机中存在的所有状态。
    }
    
    /**
     * 初始化状态迁移事件,初始化当前状态机有哪些状态事件
     */
    @Override
    public void configure( StateMachineTransitionConfigurer<RegisterStatusEnum, RegisterEventEnum> transitions ) throws Exception {
        transitions
            //1、连接事件
            //未连接->已连接
            .withExternal()
                .source( RegisterStatusEnum.UNCONNECTED )
                .target( RegisterStatusEnum.CONNECTED )
                .event( RegisterEventEnum.CONNECT )
            .and()
            //2、注册事件
            //已连接->注册中
            .withExternal()
                .source( RegisterStatusEnum.CONNECTED )
                .target( RegisterStatusEnum.REGISTERING )
                .event( RegisterEventEnum.REGISTER )
            .and()
            //3、注册成功事件
            //注册中->已注册
            .withExternal()
                .source( RegisterStatusEnum.REGISTERING )
                .target( RegisterStatusEnum.REGISTERED )
                .event( RegisterEventEnum.REGISTER_SUCCESS )
            .and()
            //4、注销事件
            //已连接->未连接
            .withExternal()
                .source( RegisterStatusEnum.CONNECTED )
                .target( RegisterStatusEnum.UNCONNECTED )
                .event( RegisterEventEnum.UN_REGISTER )
            .and()
            //注册中->未连接
            .withExternal()
                .source( RegisterStatusEnum.REGISTERING )
                .target( RegisterStatusEnum.UNCONNECTED )
                .event( RegisterEventEnum.UN_REGISTER )
            .and()
            //已注册->未连接
            .withExternal()
                .source( RegisterStatusEnum.REGISTERED )
                .target( RegisterStatusEnum.UNCONNECTED )
                .event( RegisterEventEnum.UN_REGISTER );
    }
}

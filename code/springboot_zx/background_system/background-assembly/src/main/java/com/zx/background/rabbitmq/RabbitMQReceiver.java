package com.zx.background.rabbitmq;

import org.springframework.stereotype.Service;

/**
 * @author zhongxin
 * @date 2017年8月28日
 * @description rabbitmq接收者
 */
@Service
public class RabbitMQReceiver {
    
    /**
     * @author zhongxin
     * @date 2017年8月28日
     * @description 通过 @RabbitListener 注解定义对队列的监听。
     * @param message
     */
    public void receiveMessage(String message){
        System.out.println( "Received<" + message + ">" );
    }
}

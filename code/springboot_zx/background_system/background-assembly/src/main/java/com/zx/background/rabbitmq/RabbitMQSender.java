package com.zx.background.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.config.rabbitmq.RabbitMQConfig;

/**
 * @author zhongxin
 * @date 2017年8月28日
 * @description rabbitmq发送者
 */
@Service
public class RabbitMQSender {
    
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    public void send(){
        System.out.println( "钟鑫    发送消息...." );
        rabbitTemplate.convertAndSend( RabbitMQConfig.QUEUE_NAME, "你好，钟鑫！" );
    }
}

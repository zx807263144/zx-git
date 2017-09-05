package com.zx.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zx.background.rabbitmq.RabbitMQReceiver;

/**
 * @author zhongxin
 * @date 2017年8月28日
 * @description 注册 队列，转发器，监听等
 */
@Configuration
public class RabbitMQConfig {
    
    public static final String QUEUE_NAME = "SPRING_BOOT_QUEUE";
    public static final String QUEUE_EXCHANGE_NAME="SPRING_BOOT_EXCHANGE";
    
    @Bean
    public Queue queue(){
        //是否持久化
        boolean durable = true;
        //是否仅创建者可使用的私有队列，断开后是否自动删除
        boolean exclusive = false;
        //当所有消费客户端断开连接口，是否自动删除队列
        boolean autoDelete = false;
        
        return new Queue(QUEUE_NAME,durable,exclusive,autoDelete);
    }
    
    @Bean
    public TopicExchange exchange(){
        //是否持久化
        boolean durable = true;
        //当所有消费客户端断开连接口，是否自动删除队列
        boolean autoDelete = false;
        
        return new TopicExchange( QUEUE_EXCHANGE_NAME, durable, autoDelete );
    }
    
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind( queue ).to( topicExchange ).with( QUEUE_NAME ); 
    }
    
    @Bean
    public MessageListenerAdapter listenerAdapter(RabbitMQReceiver rabbitMQReceiver){
        return new MessageListenerAdapter( rabbitMQReceiver, "receiveMessage" );
    }
    
    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter ){
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory( connectionFactory );
        listenerContainer.setMessageListener( listenerAdapter );
        listenerContainer.setQueueNames( QUEUE_NAME );
        return listenerContainer;
    }
}

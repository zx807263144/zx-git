package com.zx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zx.background.rabbitmq.RabbitMQSender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMQTest {
    
    @Autowired
    private RabbitMQSender rabbitMQSender;
    
	@Test
	public void sendTest() throws InterruptedException {
	    for (int i = 0; i < 1000; i++){
	        rabbitMQSender.send();
	    }
	    Thread.sleep( 10000 );
	}
}

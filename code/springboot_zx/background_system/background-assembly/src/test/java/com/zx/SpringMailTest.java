package com.zx;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringMailTest {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    /**
     * @author zhongxin
     * @date 2017年8月29日
     * @description 发送包含简单文本的邮件
     */
	@Test
	public void sendTextMailTest(){
	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setFrom( "******@qq.com" );
	    mailMessage.setTo( "******@qq.com" );
	    mailMessage.setSubject( "Spring Boot 邮件测试【文本】" );
	    mailMessage.setText( "这是一段简单文本" );
	    
	    javaMailSender.send( mailMessage );
	    
	    System.out.println( "文本邮件已发送" );
	}
	
	/**
	 * @author zhongxin
	 * @date 2017年8月29日
	 * @description 发送包含html的邮件
	 * @throws MessagingException
	 */
	@Test
	public void sendHtmlMailTest() throws MessagingException{
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	    MimeMessageHelper messageHelper = new MimeMessageHelper( mimeMessage );
	    
	    messageHelper.setFrom( "******@qq.com" );
	    messageHelper.setTo( "******@qq.com" );
	    messageHelper.setSubject( "Spring Boot 邮件测试【HTML】" );
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append( "<html><head></head>" );
	    sb.append( "<body><h1>springboot 邮件测试</h1><p>hello! this is spring mail test!</p></body></html>" );
	    
	    // 启用html
	    messageHelper.setText( sb.toString(), true);
	    
	    // 发送邮件
	    javaMailSender.send( mimeMessage );
	    
	    System.out.println( "HTML邮件已发送" );
	}
	
	/**
     * @author zhongxin
     * @date 2017年8月29日
     * @description 发送包含图片的html的邮件
     * @throws MessagingException
     */
    @Test
    public void sendHtmlImageTest() throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper( mimeMessage,true );
        
        messageHelper.setFrom( "******@qq.com" );
        messageHelper.setTo( "******@qq.com" );
        messageHelper.setSubject( "Spring Boot 邮件测试【图片】" );
        
        StringBuilder sb = new StringBuilder();
        sb.append( "<html><head></head>" );
        sb.append( "<body><h1>springboot 邮件测试</h1><p>hello! this is spring mail test!</p>" );
        sb.append( "<img src=\"cid:imageId\" /></body>" );
        sb.append( "</html>" );
        
        // 启用html
        messageHelper.setText( sb.toString(), true);
        
        //设置imageId
        FileSystemResource fileSystemResource = new FileSystemResource( new File("D:/01.png") );
        messageHelper.addInline( "imageId", fileSystemResource );
        
        // 发送邮件
        javaMailSender.send( mimeMessage );
        
        System.out.println( "包含图片的html邮件已发送" );
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月29日
     * @description 发送包含附件的html的邮件
     * @throws MessagingException
     */
    @Test
    public void sendHtmlAttachTest() throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper( mimeMessage,true,"utf-8" );
        
        messageHelper.setFrom( "******@qq.com" );
        messageHelper.setTo( "******@qq.com" );
        messageHelper.setSubject( "Spring Boot 邮件测试【附件】" );
        
        StringBuilder sb = new StringBuilder();
        sb.append( "<html><head></head>" );
        sb.append( "<body><h1>springboot 邮件测试</h1><p>hello! this is spring mail test!</p></body>" );
        sb.append( "</html>" );
        
        // 启用html
        messageHelper.setText( sb.toString(), true);
        
        //设置imageId
        FileSystemResource fileSystemResource = new FileSystemResource( new File("D:/01.png") );
        messageHelper.addAttachment( "image01.png", fileSystemResource );
        
        // 发送邮件
        javaMailSender.send( mimeMessage );
        
        System.out.println( "包含附件的html邮件已发送" );
    }
}

package com.zx.config.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongxin
 * @date 2017年8月25日
 * @description 当启用https时，浏览器访问http时重定向到https，因为引用只能开http或者https
 */
//@Configuration
public class TomcatConfig {
    
    /**
     * @author zhongxin
     * @date 2017年8月25日
     * @description http重定向
     * @return
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory = new TomcatEmbeddedServletContainerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint( "CONFIDENTIAL" );
                SecurityCollection securityCollection = new SecurityCollection(); 
                securityCollection.addPattern( "/" );
                securityConstraint.addCollection( securityCollection );
                context.addConstraint( securityConstraint );
            }
        };
        tomcatEmbeddedServletContainerFactory.addAdditionalTomcatConnectors( httpConnector() );
        return tomcatEmbeddedServletContainerFactory;
    }

    /**
     * @author zhongxin
     * @date 2017年8月25日
     * @description 连接重定向
     * @return
     */
    private Connector httpConnector() {
        Connector connector = new Connector( "org.apache.coyote.http11.Http11NioProtocol" );
        connector.setScheme( "http" );
        //Connector监听的http的端口号
        connector.setPort( 8080 );
        connector.setSecure( false );
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort( 8099 );
        return connector;
    }
}

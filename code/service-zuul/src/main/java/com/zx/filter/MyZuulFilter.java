package com.zx.filter;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author zhongxin
 * @date 2017年9月8日
 * @description 添加zuul的过滤功能
 */
@Component
public class MyZuulFilter extends ZuulFilter {
    
    private static Logger logger = LoggerFactory.getLogger( MyZuulFilter.class );

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request =  requestContext.getRequest();
        logger.info( "请求信息：{} >>> {}", request.getMethod(),request.getRequestURL().toString() );
        String token = request.getParameter( "token" );
        if (StringUtils.isBlank( token )){
            logger.error( "请求出错，token is empty！" );
            requestContext.setSendZuulResponse( false );
            requestContext.setResponseStatusCode( 401 );
            
            try {
                requestContext.getResponse().getWriter().write( "token is empty!" );
            } catch ( IOException e ) {
                logger.error( "向界面返回数据出错！原因：", e );
            }
            return null;
        }
        logger.info( "请求验证通过！" );
        return null;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     */
    @Override
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 过滤的顺序
     */
    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * •filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
     *  pre：路由之前
     *  routing：路由之时
     *  post： 路由之后
     *  error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }
}

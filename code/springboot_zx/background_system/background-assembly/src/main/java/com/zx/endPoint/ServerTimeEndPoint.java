package com.zx.endPoint;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhongxin
 * @date 2017年8月31日
 * @description 自定义监控端点，继承 AbstractEndpoint 抽象类。因为它是 Endpoint 接口的抽象实现，此外，我们还需要重写 invoke 方法,
 *              通过设置 @ConfigurationProperties(prefix = “endpoints.servertime”)，
 *              我们就可以在 application.properties 中通过 endpoints.servertime 配置我们的端点。
 */
@ConfigurationProperties( prefix="endpoints.servertime" )
public class ServerTimeEndPoint extends AbstractEndpoint<Map<String,Object>> {
    
    /**
     * 构造方法 ServerTimeEndpoint，两个参数分别表示端点 ID 和是否端点默认是敏感的。我这边设置端点 ID 是 servertime，它默认不是敏感的。
     */
    public ServerTimeEndPoint() {
           super("servertime",false);
    }
    
    @Override
    public Map<String, Object> invoke() {
        Map<String,Object> result = new HashMap<>();
        DateTime dateTime = DateTime.now();
        result.put( "server_time", dateTime.toString() );
        result.put( "ms_format", dateTime.getMillis() );
        return result;
    }
}

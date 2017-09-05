package com.zx.healthIndicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author zhongxin
 * @date 2017年8月31日
 * @description HealthIndicator 监控检测,实现了该接口后，监控会自动检测该类
 */
@Component
public class CusStatusHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode == 0){
            return Health.up().build();
        }
        return Health.down().withDetail( "status", errorCode )
                    .withDetail( "message", "服务故障" )
                    .build();
    }

    private int check() {
        // 对监控对象的检测操作  
        return HttpStatus.NOT_FOUND.value();
    }

}

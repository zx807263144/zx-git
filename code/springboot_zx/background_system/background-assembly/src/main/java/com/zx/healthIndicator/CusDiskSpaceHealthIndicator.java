package com.zx.healthIndicator;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

/**
 * @author zhongxin
 * @date 2017年8月31日
 * @description  HealthIndicator 监控检测,继承了该抽象类后，监控会自动检测该类
 */
@Component
public class CusDiskSpaceHealthIndicator extends AbstractHealthIndicator {
    
    private FileStore fileStore;
    
    @Value("${health.filestore.threshold.bytes:10485760}")
    private long thresholdBytes;
    
    @Autowired
    public CusDiskSpaceHealthIndicator(@Value("${health.filestore.path:/}") String path ) {
        try {
            fileStore = Files.getFileStore( Paths.get( path ) );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doHealthCheck( Builder builder ) throws Exception {
        long diskFreeInBytes = fileStore.getUnallocatedSpace();
        if (diskFreeInBytes >= thresholdBytes){
            builder.up();
        } else {
            builder.down();
        }
        
        long totalSpaceInBytes = fileStore.getTotalSpace();
        
        builder.withDetail( "disk.free", diskFreeInBytes );
        builder.withDetail( "disk.total", totalSpaceInBytes );
    }

}

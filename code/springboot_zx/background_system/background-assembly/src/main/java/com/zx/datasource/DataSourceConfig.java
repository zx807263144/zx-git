package com.zx.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author zhongxin
 * @date 2017年8月14日
 * @description mysql数据源java配置类，和springboot默认提供的配置方式都可以完成数据源配置
 */
//@Configuration
//@EnableTransactionManagement
//@PropertySource(value = {"classpath:config/datasource-dev.properties"})
public class DataSourceConfig {
    
    @Autowired
    private Environment environment;
    
    /**
     * @author zhongxin
     * @date 2017年8月14日
     * @description 创建datasource
     * @return DataSource
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName( environment.getProperty( "mysql.driver" ).trim() );
        druidDataSource.setUrl( environment.getProperty( "mysql.url" ).trim() );
        druidDataSource.setUsername( environment.getProperty( "mysql.username" ).trim() );
        druidDataSource.setPassword( environment.getProperty( "mysql.password" ).trim() );
        return druidDataSource;
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月14日
     * @description 创建jdbcTemplate
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource( dataSource() );
        return jdbcTemplate;
    }
    
}

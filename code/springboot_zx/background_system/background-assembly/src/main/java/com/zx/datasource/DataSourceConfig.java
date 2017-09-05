package com.zx.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhongxin
 * @date 2017年8月14日
 * @description mysql数据源java配置类，和springboot默认提供的配置方式都可以完成数据源配置
 */
//@Configuration
//@EnableTransactionManagement
//或者可以使用默认的配置application.properties
//@PropertySource(value = {"classpath:config/datasource-dev.properties"})
public class DataSourceConfig {
    
    /*使用datasource-dev.properties时*/
    
//    @Autowired
//    private Environment environment;
//    
//    /**
//     * @author zhongxin
//     * @date 2017年8月14日
//     * @description 创建datasource
//     * @return DataSource
//     */
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName( environment.getProperty( "mysql.driver" ).trim() );
//        druidDataSource.setUrl( environment.getProperty( "mysql.url" ).trim() );
//        druidDataSource.setUsername( environment.getProperty( "mysql.username" ).trim() );
//        druidDataSource.setPassword( environment.getProperty( "mysql.password" ).trim() );
//        return druidDataSource;
//    }
//    
//    /**
//     * @author zhongxin
//     * @date 2017年8月14日
//     * @description 创建jdbcTemplate
//     * @return JdbcTemplate
//     */
//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource( dataSource() );
//        return jdbcTemplate;
//    }
    
    /**
     * @author zhongxin
     * @date 2017年8月17日
     * @description master数据源
     * @return
     */
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource masterDataSource(){
         return DataSourceBuilder.create().build();
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月17日
     * @description slave数据源
     * @return
     */
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix="spring.datasource.slave")
    public DataSource slaveDataSource(){
        return DataSourceBuilder.create().build();
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月17日
     * @description master Jdbc
     * @param dataSource
     * @return
     */
    @Bean(name = "masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource){
        return new JdbcTemplate( dataSource );
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月17日
     * @description slave Jdbc
     * @param dataSource
     * @return
     */
    @Bean(name = "slaveJdbcTemplate")
    public JdbcTemplate slaveJdbcTemplate(@Qualifier("slaveDataSource") DataSource dataSource){
        return new JdbcTemplate( dataSource );
    }
}

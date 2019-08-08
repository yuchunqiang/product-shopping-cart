package com.fh.product.datasoucedynamic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author shangfeng
 * @Title: DataSourceConfig
 * @Package com.fh.datademo.datasoucedynamic
 * @Description: ${todo}
 * @date 2018/10/24  16:01
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "selectDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.select")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "updateDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.update")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

}

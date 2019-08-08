package com.fh.product.datasoucedynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shangfeng
 * @Title: DynamicDataSource
 * @Package com.fh.datademo.datasoucedynamic
 * @Description: ${todo}
 * @date 2018/10/24  16:06
 */
@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    @Qualifier("selectDataSource")
    private DataSource selectDataSource;

    @Autowired
    @Qualifier("updateDataSource")
    private DataSource updateDataSource;

    /**
     * 这个是主要的方法，返回的是生效的数据源名称
     */
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("DataSourceContextHolder：：："+DataSourceContextHolder.getDbType());
        return DataSourceContextHolder.getDbType();
    }

    /**
     * 自己配的时候老是报什么没有指定target这里设置一下，默认数据源是updateDataSource
     */
    @Override
    public void afterPropertiesSet() {
        Map<Object,Object> map = new HashMap<>();
        map.put("selectDataSource",selectDataSource);
        map.put("updateDataSource",updateDataSource);
        setTargetDataSources(map);
        setDefaultTargetDataSource(updateDataSource);
        super.afterPropertiesSet();
    }
}

package com.fh.product.datasoucedynamic;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author shangfeng
 * @Title: DataSourceContextHolder
 * @Package com.fh.datademo.datasoucedynamic
 * @Description: ${todo}
 * @date 2018/10/24  16:00
 */
@Component
@Lazy(false)
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDbType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        return contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}

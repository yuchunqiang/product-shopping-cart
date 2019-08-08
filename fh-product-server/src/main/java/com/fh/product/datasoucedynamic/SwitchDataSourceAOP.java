package com.fh.product.datasoucedynamic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author shangfeng
 * @Title: SwitchDataSourceAOP
 * @Package com.fh.datademo.datasoucedynamic
 * @Description: ${todo}
 * @date 2018/10/24  15:54
 */
@Aspect
@Component
@Lazy(false)
@Order(0) //Order设定AOP执行顺序 使之在数据库事务上先执行
public class SwitchDataSourceAOP {

    //这里切到你的方法目录
    @Before("execution(* com.fh.product.service.*.*.*(..))")
    public void process(JoinPoint joinPoint) {
        String methodName=joinPoint.getSignature().getName();
        if (methodName.startsWith("get")
                ||methodName.startsWith("count")
                ||methodName.startsWith("find")
                ||methodName.startsWith("list")
                ||methodName.startsWith("select")
                ||methodName.startsWith("check")
                ||methodName.startsWith("query")){
            DataSourceContextHolder.setDbType("selectDataSource");
        }else {
            //切换dataSource
            DataSourceContextHolder.setDbType("updateDataSource");
        }
    }

}

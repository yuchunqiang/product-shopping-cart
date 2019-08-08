package com.fh.product.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
//什么时候使用
@Retention(RetentionPolicy.RUNTIME)
//哪种类型使用 类 方法 参数 属性 这里是方法
@Target(ElementType.METHOD)
public @interface LogAnnotation {
  String methodInfo()default"";
}

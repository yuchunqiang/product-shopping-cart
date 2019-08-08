package com.fh.product.aop;


import com.fh.product.bean.User;
import com.fh.product.service.mongodb.IMongoDBService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


@Aspect
@Component
public class ILogAspect {

    @Autowired
    private IMongoDBService aspectService;

    @Pointcut("execution(* com.fh.product.controller..*.*(..))")
    public void doMethod() {

    }

    @Before("doMethod()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("之前");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("beginTime", new Date().getTime());
    }

    @After("doMethod()")
    public void afterAdvice(JoinPoint joinPoint) throws ClassNotFoundException {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        if (null != user) {
            Log log = new Log();
            log.setUserid(user.getUserId());
            log.setUsername(user.getUserName());
            log.setIpaddress(request.getRemoteAddr());
            String classname = joinPoint.getTarget().getClass().getName();
            log.setClassname(classname);
            String methodname = joinPoint.getSignature().getName();
            log.setMethodname(methodname);
            log.setAddtime(new Date());
            long endtime = new Date().getTime();
            long starttime = (long) request.getSession().getAttribute("beginTime");
            log.setExcutetime(new Date(endtime - starttime));
            //或取方法的参数通过反射得到对应的方法
            String params = "";
            Object[] args = joinPoint.getArgs();
            Class clazz = Class.forName(classname);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodname)) {
                    //得到该方法的参数类型
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == args.length) {
                        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
                        if (null != annotation) {
                           log.setDescription(annotation.methodInfo());
                        }
                    }
                }
            }
            System.out.println(methodname);
            System.out.println(log);
            aspectService.addOptionLog(log);
        }
        request.getSession().removeAttribute("beginTime");
        System.out.println("之后");
    }

    @AfterThrowing(pointcut = "doMethod()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("异常");
    }

}

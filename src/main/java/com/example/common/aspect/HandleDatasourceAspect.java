package com.example.common.aspect;

import com.example.common.annotation.DataSource;
import com.example.common.config.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

/**
 * @author  zxc
 * @date  2019/08/16
 */
@Aspect
@Component
public class HandleDatasourceAspect {

    @Pointcut("@annotation(com.example.common.annotation.DataSource)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforeExecute(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if (null == annotation) {
            annotation = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
        }
        if (null != annotation) {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceType(annotation.name());
        }
    }

    @After("pointcut()")
    public void afterExecute() {
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}

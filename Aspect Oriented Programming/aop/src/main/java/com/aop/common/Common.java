package com.aop.common;

import com.aop.aspect.LogAspectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Project aop
 * User : suren_v
 * Date : 11/28/2019
 * Time : 2:16 PM
 */
@Component
public class Common {

    private static Logger logger = LogManager.getLogger(Common.class);

    public void logObjectContent(JoinPoint joinPoint, Object object ) throws IllegalAccessException {
        String result = "";
        String classname = joinPoint.getTarget().getClass().getName();
        String methodname = joinPoint.getSignature().getName();
        logger.info("-----------------------------------------------------------");
        logger.info("class name and method name : " + classname + "  " + methodname);
        for (Field field: object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(object);
            result += "  " + name + " " + value;
        }
        logger.info("object attributes : " + result);
        logger.info("-----------------------------------------------------------");
    }
}

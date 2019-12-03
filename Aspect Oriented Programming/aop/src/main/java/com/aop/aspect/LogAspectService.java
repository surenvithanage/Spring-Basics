package com.aop.aspect;

import com.aop.common.Common;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project aop
 * User : suren_v
 * Date : 11/28/2019
 * Time : 10:04 AM
 */
@Aspect
@Component
public class LogAspectService {
    private static Logger logger = LogManager.getLogger(LogAspectService.class);

    @Autowired
    private Common common;

    // ------------------------------------------------------------------------
    // These two methods are used for services which passes a parameter and returns an object
    // ------------------------------------------------------------------------

    @Before(value = "@annotation(LoggableService) && args(object,..)")
    public void beforeServiceLog( JoinPoint joinPoint, Object object ) {
        try {
            if ( object != null ) {
                common.logObjectContent(joinPoint,object);
            }
        } catch ( IllegalAccessException ae) {
            logger.error("IllegalAccessException : " + ae);
        } catch ( Exception e) {
            logger.error("Exception : " + e);
        }
    }

    @AfterReturning(value = "@annotation(LoggableService)", returning = "object")
    public void afterServiceLog( JoinPoint joinPoint, Object object ) {
        try {
            if ( object != null ) {
                common.logObjectContent(joinPoint,object);
            }
        } catch ( IllegalAccessException ae) {
            logger.error("IllegalAccessException : " + ae);
        } catch ( Exception e) {
            logger.error("Exception : " + e);
        }
    }

}

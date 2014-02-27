package com.portfolio.aspect;

import com.portfolio.exception.ApplicationException;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;

/**
 * Created by e7006722 on 26/02/14.
 */
@Aspect
public class LoggingAspect {
    private Logger logger;

    @Around("execution(* com.portfolio..*.*(..))")
    public Object doMethodLogging(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        Class declaringType = pjp.getSignature().getDeclaringType();
        logger = Logger.getLogger(declaringType);

        logger.debug(methodName + " called with args..." + pjp.getArgs());
        Object retVal = pjp.proceed();
        logger.debug(methodName + " returned with value..." + retVal);

        return retVal;
    }

    @AfterThrowing(pointcut = "execution(* com.portfolio..*.*(..))",
            throwing = "ae"
    )
    public void doExceptionLogging(JoinPoint joinPoint, ApplicationException ae) {
        Class clazz = joinPoint.getClass();
        String methodName = joinPoint.getSignature().getName();
        logger = Logger.getLogger(clazz);
        logger.debug(clazz.getName() + "." + methodName + " throws exception..." + ae.toString());
    }
}

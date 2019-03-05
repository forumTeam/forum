package com.forum.aop;

import com.forum.common.model.ResultModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 功能描述：定义一个 Pointcut, 使用 切点表达式函数 来描述对哪些 Join point 使用 advise.
     */
    @Pointcut("execution(* com.forum.controller.*..*(..))")
    public void pointcut() {
    }

    /**
     * 功能描述：统一捕捉异常，进行事务回滚.
     * @param method
     * @return
     */
    @Around("pointcut()")
    public Object methodBefore(ProceedingJoinPoint method) {
        Object methodExecutedResult;
        try {
            methodExecutedResult = method.proceed(method.getArgs());
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
            return ResultModel.getErrorResultModel(throwable.getMessage());
        }
        return methodExecutedResult;
    }
}

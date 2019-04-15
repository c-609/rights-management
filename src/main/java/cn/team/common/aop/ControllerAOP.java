package cn.team.common.aop;

import cn.team.common.beans.ResultBean;
import cn.team.common.exception.CheckException;
import cn.team.common.exception.UnloginException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.naming.NoPermissionException;

/**
 * create by yifeng
 */
@Aspect
@Component
public class ControllerAOP {
    /**
     * 处理和包装异常
     * create by yifeng
     */

    private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    @Around("execution(public cn.team.common.beans.ResultBean *(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;

        try {
            result = (ResultBean<?>) pjp.proceed();

            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("[{}]use time: {}", pjp.getSignature(), elapsedTime);
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e){
        ResultBean<?> result = new ResultBean<>();

        // 已知异常不打印堆栈
        // 校验出错, 参数非法
        if(e instanceof CheckException || e instanceof IllegalArgumentException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.CHECK_FAIL);
        }
        // 没有登陆
        else if(e instanceof UnloginException) {
            result.setMsg("Unlogin");
            result.setCode(ResultBean.NO_LOGIN);
        }
        else if(e instanceof NoPermissionException) {
            result.setMsg("No PERMISSION");
            result.setCode(ResultBean.NO_PERMISSION);
        }else {
            logger.error(pjp.getSignature() + "error", e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.UNKNOWN_EXCEPTION);
        }

        return result;
    }
    
}

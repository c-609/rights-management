package cn.team.common.security.component;

import cn.team.common.constant.SecurityConstants;
import org.apache.ibatis.javassist.runtime.Inner;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by yifeng
 */
public class SecurityInnerAspect implements Ordered {

//    private final HttpServletRequest request;

//    @Around("@annotation()")
//    public Object around(ProceedingJoinPoint point, Inner inner) {
////        String header = request.getHeader(SecurityConstants.FROM);
////        if (inner.) {
////        }
//        return point.proceed();
//    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}

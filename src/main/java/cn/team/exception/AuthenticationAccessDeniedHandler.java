package cn.team.exception;

import cn.team.common.beans.ResultBean;
import cn.team.common.constant.CommonConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sang on 2017/12/29.
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp,
                       AccessDeniedException e) throws IOException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ResultBean resultBean = new ResultBean("权限不足，请联系管理员!");
        resultBean.setCode(CommonConstants.NO_PERMISSION);
        out.write(new ObjectMapper().writeValueAsString(resultBean));
        out.flush();
        out.close();
    }
}

package cn.team.exception;


import cn.team.common.constant.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import cn.team.common.beans.ResultBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * security 异常统一处理
 * create by yifeng
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) {
        logger.error("CustomExceptionResolver: " + e);
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        ResultBean<String> resultBean = new ResultBean<>();
        if (e instanceof DataIntegrityViolationException) {
            resultBean.setCode(CommonConstants.CHECK_FAIL);
            resultBean.setData("该角色尚有关联的资源或用户，删除失败!");
        }  else {
            resultBean.setCode(CommonConstants.CHECK_FAIL);
            resultBean.setData("LOGIN FAIL!");
        }
        mv.addObject(resultBean);
        return mv;
    }
}

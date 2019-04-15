package cn.team.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.team.bean.RespBean;
import cn.team.bean.ResultBean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */
@RestController
public class RegLoginController {
	 @RequestMapping("/login_p")
	    public RespBean login() {
	        return RespBean.error("尚未登录，请登录!");
	    }
}

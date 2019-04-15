package cn.team.controller;


import cn.team.common.beans.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
public class RegLoginController {
	 @RequestMapping("/login_p")
	    public ResultBean login() {
	 		ResultBean resultBean = new ResultBean();
	 		resultBean.setCode(ResultBean.NO_LOGIN);
	        return resultBean;
	    }
}

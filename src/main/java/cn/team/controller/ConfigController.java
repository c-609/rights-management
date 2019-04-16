package cn.team.controller;

import cn.team.common.beans.ResultBean;
import cn.team.common.util.UserUtil;
import cn.team.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/sysmenu")
    @ResponseBody
    public ResultBean sysmenu() {
        return new ResultBean(menuService.menuTree());
    }

    @RequestMapping("/user")
    @ResponseBody
    public ResultBean currentUser() {
        return new ResultBean(UserUtil.getCurrentUser());
    }

}

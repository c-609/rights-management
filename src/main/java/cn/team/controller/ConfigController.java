package cn.team.controller;

import cn.team.bean.Menu;
import cn.team.bean.Role;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.common.util.UserUtil;
import cn.team.service.MenuService;
import cn.team.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/sysmenu")
    @ResponseBody
    public ResultBean<List<Menu>> sysmenu() {
        return new ResultBean(menuService.getMenusByUId());
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public ResultBean<User> currentUser() {
        return new ResultBean(UserUtil.getCurrentUser());
    }

    @RequestMapping(value = "/allroles")
    @ResponseBody
    public ResultBean<Role> allroles() {
       return new ResultBean(roleService.roles());
    }

}

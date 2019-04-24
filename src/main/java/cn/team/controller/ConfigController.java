package cn.team.controller;

import cn.team.bean.Menu;
import cn.team.bean.Role;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.common.util.UserUtil;
import cn.team.dto.MenuTree;
import cn.team.service.MenuService;
import cn.team.service.RoleService;
import cn.team.vo.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    /**
     * 返回树形菜单
     * @return
     */
    @RequestMapping("/sysmenu")
    @ResponseBody
    public ResultBean<List<Menu>> sysmenu() {
        return new ResultBean(TreeUtil.buildTree(menuService.getMenusByUId(), -1));
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

    @RequestMapping(value = "/allmenuTree", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean<List<Menu>> allMenu() {
        TreeUtil.buildTree(menuService.list(), -1);
        return new ResultBean(TreeUtil.buildTree(menuService.list(), -1));
    }

    @RequestMapping(value = "/menuIdByRid", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<List<Integer>> getMenusByRid(Long rid) {
        List<MenuTree> listMenu = TreeUtil.findLeafNode(TreeUtil.buildTree(menuService.getMenusByRid(rid), -1));
        List<Integer> resultList = new ArrayList<>();
        listMenu.stream().forEach(item -> {
            resultList.add(item.getId());
        });
        return new ResultBean<>(resultList);
    }

}

package cn.team.controller;

import cn.team.bean.Dept;
import cn.team.bean.Menu;
import cn.team.bean.Role;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.common.util.UserUtil;
import cn.team.dto.MenuTree;
import cn.team.service.DeptService;
import cn.team.service.MenuService;
import cn.team.service.RoleService;
import cn.team.vo.TreeUtil;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private DeptService deptService;

    /**
     * 返回树形菜单
     * @return
     */
    @RequestMapping("/sysmenu")
    @ResponseBody
    @Deprecated
    public ResultBean<List<Menu>> sysmenu() {
        return new ResultBean(TreeUtil.buildTree(menuService.getMenusByUId(), -1));
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    @Deprecated
    public ResultBean<User> currentUser() {
        return new ResultBean(UserUtil.getCurrentUser());
    }

    @RequestMapping(value = "/allroles")
    @ResponseBody
    @Deprecated
    public ResultBean<Role> allroles() {
       return new ResultBean(roleService.roles());
    }

    @RequestMapping(value = "/getDeptIdByRoles")
    @ResponseBody
    @Deprecated
    public ResultBean getDeptIdByRoles(int deptId) {
        return new ResultBean(roleService.findRolesByDeptid(deptId));
    }

    @GetMapping(value = "/findDeptsByRoleid")
    @ResponseBody
    @Deprecated
    public ResultBean getRoleIdByDepts(int roleId) {
        // 转换成id数组返回给前端
        List<Dept> deptList = deptService.findDeptsByRoleid(roleId);
        var resultList = new ArrayList<Integer>(deptList.size());
        deptList.stream().forEach(node -> {
            resultList.add(node.getId());
        });
        return new ResultBean(resultList);
    }


    @RequestMapping(value = "/allmenuTree", method = RequestMethod.GET)
    @ResponseBody
    @Deprecated
    public ResultBean<List<Menu>> allMenu() {
        TreeUtil.buildTree(menuService.list(), -1);
        return new ResultBean(TreeUtil.buildTree(menuService.list(), -1));
    }

    @RequestMapping(value = "/menuIdByRid", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public ResultBean<List<Integer>> getMenusByRid(Long rid) {
        List<MenuTree> listMenu = TreeUtil.findLeafNode(TreeUtil.buildTree(menuService.getMenusByRid(rid), -1));
        List<Integer> resultList = new ArrayList<>();
        listMenu.stream().forEach(item -> {
            resultList.add(item.getId());
        });
        return new ResultBean<>(resultList);
    }

}

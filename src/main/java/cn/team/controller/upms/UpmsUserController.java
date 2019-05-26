package cn.team.controller.upms;

import cn.team.bean.Menu;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.common.util.UserUtil;
import cn.team.service.MenuService;
import cn.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/upms/user")
public class UpmsUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    @ResponseBody
    public ResultBean<List<User>> getAllUser() {
        return new ResultBean(userService.getAllUser());
    }

    /**
     * 获取当前登录用户的具体信息
     * @return
     */
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean<User> currentUser() {
        return new ResultBean(UserUtil.getCurrentUser());
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('user_basic_add')")
    public ResultBean<Integer> addUser(@RequestBody User user, Long rids[]) {
        return new ResultBean(userService.addUser(user, rids));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('user_basic_delete')")
    public ResultBean<Integer> deleteUser(Long uid) {
        return new ResultBean(userService.deleteUserByUId(uid));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('user_basic_update')")
    public ResultBean<Integer> updateUser(@RequestBody User user,Long[] roleIds) {
        return new ResultBean(userService.updateUser(user, roleIds));
    }

    @RequestMapping(value = "/menuTree", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<List<Menu>> sysmenu(Long uid) {
        return new ResultBean(menuService.getMenuTreeByUId(uid));
    }

    @RequestMapping(value = "/getListByDeptId", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean<List<User>> getByDeptId(int deptId) {
        return new ResultBean<>(userService.getUserlistByDeptId(deptId));
    }

}

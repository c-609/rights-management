package cn.team.controller.upms;

import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/")
    @ResponseBody
    public ResultBean<List<User>> getAllUser() {
        return new ResultBean(userService.getAllUser());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Integer> addUser(User user, Long rids[]) {
        return new ResultBean(userService.addUser(user, rids));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Integer> deleteUser(Long uid) {
        return new ResultBean(userService.deleteUserByUId(uid));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Integer> updateUser(@RequestBody User user) {
        return new ResultBean(userService.updateUser(user));
    }

}

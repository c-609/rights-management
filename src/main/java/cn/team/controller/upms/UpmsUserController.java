package cn.team.controller.upms;

import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.service.UserService;
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
    public ResultBean<Integer> addUser(User user) {
        return new ResultBean(userService.addUser(user));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Integer> deleteUser(String username) {
        return new ResultBean(userService.deleteUserByUsername(username));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Integer> updateUser(User user) {
        return new ResultBean(userService.updateUser(user));
    }

}

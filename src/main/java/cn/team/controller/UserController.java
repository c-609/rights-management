package cn.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.team.bean.User;
import cn.team.service.MenuService;
import cn.team.service.RoleService;
import cn.team.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String username) {
			Map<String, Object> map = new HashMap<>();
        List<User> userByPage = userService.getAllUserByPage(page, size,username);
        Long count = userService.getCountByUsername(username);
        map.put("users", userByPage);
        map.put("count", count);
        return map;
    }
	
}

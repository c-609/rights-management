package cn.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="/menu")
	public Map<String,Object> menus(){
		Map map = new HashMap<String, Object>();
		map.put("menus", menuService.getAllMenu());
		return map;
	}
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/role")
	public Map<String,Object> roles(){
		Map map = new HashMap<String, Object>();
		map.put("roles", roleService.roles());
		return map;
	}
	
//	@RequestMapping(value="/getUserByUsername/{username}") 
//    public String getUserByUsername(@PathVariable String username){
//        return (userService.getUserByUsername(username)).toString();
//    }
//	@RequestMapping(value="/addUser") 
//    public String addUser(){
//		User user = null;
//		user.setUsername("1111");
//		user.setPassword("123");
//		int i = userService.addUser(user);
//        return i==1?"cg":"sb";
//    }
	
	
}

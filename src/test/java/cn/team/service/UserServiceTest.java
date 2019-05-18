package cn.team.service;


import cn.team.RightsManageApplicationTest;
import cn.team.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceTest extends RightsManageApplicationTest {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Test
    public void testFindUserByUsername() {
        String username = "admin1";
        User user = userService.getUserByUsername(username);
        System.out.println(user);
    }

    @Test
    public void testGetAllUesr() {
        List userList = userService.getAllUser();
        System.out.println(userList);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(150L);
        user.setUsername("www");
        Long[] rids = {8L, 18L, 38L};
        int rowCount = userService.updateUser(user, rids);
        System.out.println(rowCount);
    }

    @Test
    public void testDeleteUserByUId() {
        int rowCount = userService.deleteUserByUId(32L);
        System.out.println(rowCount);
    }

    @Test
    @Rollback
    @Transactional
    public void testAddUser() {
        User user = new User();
        user.setPassword("123");
        user.setUsername("haoshuai");
        user.setStatus(0);
        Long rids[] = {5L, 1L};
        int rowCount = userService.addUser(user, rids);
        System.out.println(rowCount);
    }


}

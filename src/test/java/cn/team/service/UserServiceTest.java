package cn.team.service;


import cn.team.RightsManageApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;

import java.util.List;

public class UserServiceTest extends RightsManageApplicationTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetAllUesr() {
        List userList = userService.getAllUser();
        System.out.println(userList);
    }


}

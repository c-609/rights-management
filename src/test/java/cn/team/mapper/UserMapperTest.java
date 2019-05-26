package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * create by yifeng
 */
public class UserMapperTest extends RightsManageApplicationTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testUpdateDeptAuthForRole() {
        List<User> resultList = userMapper.selectUsersByGroupId(1);
        System.out.println(resultList);
    }


}

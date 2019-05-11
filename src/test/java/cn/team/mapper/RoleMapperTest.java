package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by yifeng
 */
public class RoleMapperTest extends RightsManageApplicationTest {
    @Autowired
    RoleMapper roleMapper;

    @Test
    public void testUpdateDeptAuthForRole() {
        int[] dids = new int[2];
        dids[0] = 1;
        dids[1] = 14;
        int result = roleMapper.updateDeptAuthForRole(18, dids);
        System.out.println(result);
    }

    @Test
    public void testDeleteDeptAuthForRole() {
        int result = roleMapper.deleteDeptAuthForRole(18);
        System.out.println(result);
    }


}

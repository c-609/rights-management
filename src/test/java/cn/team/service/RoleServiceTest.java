package cn.team.service;

import cn.team.RightsManageApplicationTest;
import cn.team.mapper.MenuRoleMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by yifeng
 */
public class RoleServiceTest extends RightsManageApplicationTest {


    @Autowired
    MenuRoleService menuRoleService;

    @Test
    @Rollback
    @Transactional
    public void testUpdateMenuRole() {
        Long mids[] = new Long[4];
        mids[0] = 9L;
        mids[1] = 10L;
        mids[2] = 11L;
        mids[3] = 12L;
        System.out.println(menuRoleService.updateMenuRole(6L, mids));
    }

}

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

    @Autowired
    RoleService roleService;

    @Test
    @Rollback
    @Transactional
    public void testUpdateMenuRole() {
        Long mids[] = new Long[4];
        mids[0] = 15L;
        mids[1] = 14L;
//        mids[2] = 11L;
//        mids[3] = 12L;
        System.out.println(menuRoleService.updateMenuRole(8L, mids));
    }

    @Test
    @Rollback
    @Transactional
    public void testDeleteRole() {
        int rowCount = roleService.deleteRoleById(7L);
        System.out.println(rowCount);
    }

    @Test
    @Rollback
    @Transactional
    public void testUpdateRole() {

    }

}

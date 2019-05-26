package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by yifeng
 */
public class UGroupRoleMapperTest extends RightsManageApplicationTest {

    @Autowired
    private UGroupRoleMapper uGroupRoleMapper;

    @Test
    public void testInsertListByrid() {
        int[] gids = {5};
        int result = uGroupRoleMapper.insertListByrid(1, gids);
        System.out.println(result);
    }

    @Test
    public void testInsertListBygid() {
        int[] rids = {82, 139};
        int result = uGroupRoleMapper.insertListBygid(1, rids);
        System.out.println(result);
    }



    @Test
    public void testDeleteByRoleId() {
        Boolean result = uGroupRoleMapper.deleteByrid(1);
        System.out.println(result);
    }

    @Test
    public void testDeleteByGroupId() {
        Boolean result = uGroupRoleMapper.deleteByUGroupId(1);
        System.out.println(result);
    }


}

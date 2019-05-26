package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.UGroup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * create by yifeng
 */
public class UGroupUserMapperTest extends RightsManageApplicationTest {

    @Autowired
    private UGroupUserMapper uGroupUserMapper;

    @Test
    public void testInsertListByuid() {
        int[] gids = {3};
        int result = uGroupUserMapper.insertListByuid(1, gids);
        System.out.println(result);
    }

    @Test
    public void testInsertListBygid() {
        int[] uids = {82, 139};
        int result = uGroupUserMapper.insertListBygid(1, uids);
        System.out.println(result);
    }



    @Test
    public void testDeleteByUserId() {
        Boolean result = uGroupUserMapper.deleteByUserId(29);
        System.out.println(result);
    }

    @Test
    public void testDeleteByGroupId() {
        Boolean result = uGroupUserMapper.deleteByUGroupId(1);
        System.out.println(result);
    }


}

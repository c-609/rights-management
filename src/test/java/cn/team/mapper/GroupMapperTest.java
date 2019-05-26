package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.UGroup;
import cn.team.bean.UGroup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * create by yifeng
 */
public class GroupMapperTest extends RightsManageApplicationTest {

    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void testGetDeptByid() {
        List<UGroup> groupList = groupMapper.selectGroupsByUserId(180L);
        System.out.println(groupList.size());
    }

    @Test
    public void testGetById() {
        UGroup uGroup = groupMapper.getById(1);
        System.out.println(uGroup.getName());
    }

    @Test
    public void save() {
        UGroup group = new UGroup();
        group.setName("www");
        group.setParentId(-1);
        group.setUpdateTime(LocalDateTime.now());
        boolean result = groupMapper.save(group);
        System.out.println(result);
    }

    @Test
    public void update() {
        UGroup group = new UGroup();
        group.setId(3);
        group.setParentId(1);
        group.setUpdateTime(LocalDateTime.now());
        boolean result = groupMapper.updateById(group);
        System.out.println(result);
    }

   @Test
    public void delete() {
        boolean result = groupMapper.removeById(5);
        System.out.println(result);
    }



}

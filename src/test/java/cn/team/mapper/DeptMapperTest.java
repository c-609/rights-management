package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.Dept;
import cn.team.bean.Menu;
import cn.team.dto.MenuTree;
import cn.team.vo.TreeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * create by yifeng
 */
public class DeptMapperTest extends RightsManageApplicationTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testGetDeptByid() {
        Dept dept = deptMapper.getDeptById(2);
        System.out.println(dept.getName());
    }


}

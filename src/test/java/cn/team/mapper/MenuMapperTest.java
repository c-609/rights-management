package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * create by yifeng
 */
public class MenuMapperTest extends RightsManageApplicationTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testGetMenuByUid() {
        List<Menu> list = menuMapper.getMenusByUId(3L);
        System.out.println(list);
    }

    @Test
    public void testGetAllMenu() {
        List<Menu> list = menuMapper.getAllMenu();
        System.out.println(list.size());
    }

}

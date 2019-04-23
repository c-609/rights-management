package cn.team.mapper;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.Menu;
import cn.team.dto.MenuTree;
import cn.team.vo.TreeUtil;
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
        List<Menu> list = menuMapper.getMenuTreeByUId(139L);
        System.out.println(list);
    }

    @Test
    public void testGetAllMenu() {
        List<Menu> list = menuMapper.getAllMenu();
        List<MenuTree> listTree = TreeUtil.buildTree(list, -1);
        System.out.println();
    }

    @Test
    public void testListByUid() {
        List<Menu> list = menuMapper.listByUid(139L);
        System.out.println(list);
    }

}

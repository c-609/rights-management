package cn.team.service;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.Menu;
import cn.team.mapper.MenuMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create by yifeng
*/
public class MenuServceTest extends RightsManageApplicationTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void testGetMenuByUId() {
//        List<Menu> list = menuService.getMenusByUId();

//        System.out.println(list);
    }

    @Test
    public void testAllMenu() {
        List<Menu> menuList = menuService.getAllMenu();
        System.out.println(menuList.size());
    }

    @Test
    public void testGetMenuTreeByUid() {
        List<Menu> menuList = menuService.getMenuTreeByUId(76L);
        System.out.println(menuList);
    }

    @Test
    public void testUpdate() {
        Menu menu = new Menu();
        menu.setId(232L);
        menu.setName("你好帅");
        int rowCount = menuService.updateMenu(menu);
        System.out.println(rowCount);
    }

    @Test
    public void testMenuTree() {
        List<Menu> list = menuService.getMenuTree();
        System.out.println(list);
    }

    @Test
    public void testAddMenu() {
        // {url},#{path},#{component},#{name},#{iconCls},1,#{parantId}
        Menu menu = new Menu();
        menu.setName("12");
        menu.setParentId(4L);
        menu.setUrl("1");
        menu.setPath("111");
        menu.setComponent("111");
        menu.setIconCls("111");
        int rowCount = menuService.addMunu(menu);
        System.out.println(rowCount);
    }

    @Test
//    @Transactional
//    @Rollback
    public void testUpdateMenu() {
        Menu menu = new Menu();
        menu.setId(236L);
        menu.setName("测试");
        int rowCount = menuService.updateMenu(menu);
        System.out.println(rowCount);
    }

}

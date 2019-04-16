package cn.team.service;

import cn.team.RightsManageApplicationTest;
import cn.team.bean.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * create by yifeng
*/
public class MenuServceTest extends RightsManageApplicationTest {

    @Autowired
    private MenuService menuService;



    @Test
    public void testAllMenu() {
        List<Menu> menuList = menuService.getAllMenu();
        System.out.println(menuList.size());
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
        List<Menu> list = menuService.menuTree();
        System.out.println(list);
    }

}

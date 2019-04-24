package cn.team.controller.upms;

import cn.team.bean.Menu;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.dto.MenuTree;
import cn.team.service.MenuService;
import cn.team.vo.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/upms/menu")
public class UpmsMenuController {

    @Autowired
    private MenuService menuService;


    /**
     * 返回当前用户的树型菜单
     * @return 当前用户的树形菜单
     */
    @GetMapping
//    @ResponseBody
    public ResultBean<List<MenuTree>> getUserMenu() {
        List menuList = menuService.getMenusByUId();
        return new ResultBean(TreeUtil.buildTree(menuList, -1));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultBean<List<MenuTree>> getMenu() {
        return new ResultBean(menuService.list());
    }

    /**
     * 返回树形菜单集合
     * @return 树形菜单
     */
    @GetMapping(value = "/tree")
    public ResultBean getTree() {
        return new ResultBean(TreeUtil.buildTree(menuService.getAllMenu(), -1));
    }

    //TODO 将废弃
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean<List<Menu>> getAllList() {
        return new ResultBean(menuService.getAllMenu());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addMenu(Menu menu) {
        return new ResultBean<Integer>(menuService.addMunu(menu));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Integer> deleteMenu(int mid) {
        return new ResultBean(menuService.deleteMenu(mid));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Integer> updateMenu(Menu menu) {
        return new ResultBean(menuService.updateMenu(menu));
    }

    @RequestMapping(value = "/getMenusByRid", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<List<Menu>> getMenusByRid(Long rid) {
        return new ResultBean<>(menuService.getMenusByRid(rid));
    }

}

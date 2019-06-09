package cn.team.controller.upms;

import cn.team.bean.Menu;
import cn.team.common.beans.ResultBean;
import cn.team.dto.MenuTree;
import cn.team.service.MenuService;
import cn.team.vo.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResultBean<List<MenuTree>> getUserMenu() {
        List menuList = menuService.getMenusByUId();
        return new ResultBean(TreeUtil.buildTree(menuList, -1));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultBean<List<MenuTree>> getMenu() {
        return new ResultBean(menuService.list());
    }

    /**
     * 返回当前用户的树形菜单
     * @return 树形菜单
     */
    @GetMapping(value = "/tree")
    @Deprecated
    public ResultBean getTree() {
        return new ResultBean(TreeUtil.buildTree(menuService.getAllMenu(), -1));
    }

    /**
     * 菜单对应的角色id
     * @param rid
     * @return
     */
    @RequestMapping(value = "/tree/{rid}", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean<List<Menu>> getMenuListByRid(@PathVariable Long rid) {
        List<MenuTree> listMenu = TreeUtil.findLeafNode(TreeUtil.buildTree(menuService.getMenusByRid(rid), -1));
        List<Integer> resultList = new ArrayList<>();
        listMenu.stream().forEach(item -> {
            resultList.add(item.getId());
        });
        return new ResultBean(resultList);
    }



    // 此方法已经废弃
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultBean<List<Menu>> getAllList() {
//        return new ResultBean(menuService.getAllMenu());
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('upms_menu_add')")
    public ResultBean addMenu(Menu menu) {
        return new ResultBean<Integer>(menuService.addMunu(menu));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('upms_menu_delete')")
    public ResultBean<Integer> deleteMenu(int mid) {
        return new ResultBean(menuService.deleteMenu(mid));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('upms_dept_update')")
    public ResultBean<Integer> updateMenu(Menu menu) {
        return new ResultBean(menuService.updateMenu(menu));
    }

    @RequestMapping(value = "/getMenusByRid", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public ResultBean<List<Menu>> getMenusByRid(Long rid) {
        return new ResultBean<>(menuService.getMenusByRid(rid));
    }



}

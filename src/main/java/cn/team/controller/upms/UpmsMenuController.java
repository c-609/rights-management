package cn.team.controller.upms;

import cn.team.bean.Menu;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/upms/menu")
public class UpmsMenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean<List<Menu>> getAllMenu() {
        return new ResultBean(menuService.getMenuTree());
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

}

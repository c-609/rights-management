package cn.team.controller.upms;

import cn.team.bean.Menu;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultBean getAllMenu() {
        return new ResultBean(menuService.getAllMenu());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addMenu(Menu menu) {
        return new ResultBean<>(menuService.addMunu(menu));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean deleteMenu(int mid) {
        return new ResultBean(menuService.deleteMenu(mid));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean updateMenu(Menu menu) {
        return new ResultBean(menuService.updateMenu(menu));
    }

}

package cn.team.controller.upms;

import cn.team.bean.Menu;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by yifeng
 */
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
//        return new ResultBean(menuService(user));
        //TODO 删除菜单
        menuService.deleteMenu(mid);
        return null;
    }

    public ResultBean updateMenu(Menu menu) {
        return new ResultBean(menuService.updateMenu(menu));
    }

}

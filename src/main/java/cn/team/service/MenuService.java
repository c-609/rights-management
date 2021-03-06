package cn.team.service;

import java.util.List;

import cn.team.common.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.bean.Menu;
import cn.team.mapper.MenuMapper;



@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

//    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    /**
     * 获取menu list集合
     * @return list 集合，仅menu
     */
    public List<Menu> list() {
        return menuMapper.list();
    }


    public List<Menu> getMenuTreeByUId(Long uid) {
        return menuMapper.getMenuTreeByUId(uid);
    }

    public List<Menu> getMenusByUId() {
        return menuMapper.listByUid(UserUtil.getCurrentUser().getId());
    }

    public List<Menu> getMenuTree() {
        return menuMapper.list();
    }

    public List<Menu> getMenusByRid(Long rid) {

        return menuMapper.getMenusByRid(rid);
    }

    public int addMunu(Menu menu) {
        if (menu.getParentId() == null || menu.getParentId() == 0) {
            menu.setParentId(-1);
        }
        return menuMapper.addMenu(menu);
    }

    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    public int deleteMenu(int mid) {
        return menuMapper.deleteMenuById(mid);
    }

}

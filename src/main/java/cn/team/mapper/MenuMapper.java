package cn.team.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.team.bean.Menu;

/**
 * Created by sang on 2017/12/28.
 */
@Mapper
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByUId(Long Uid);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
    
    int addMenu(Menu menu);
    
    int deleteMenuById(@Param("mid") int mid);

    int updateMenu(@Param("menu") Menu menu);
}

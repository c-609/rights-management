package cn.team.service;

import cn.team.mapper.MenuRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.log.ReliableLog;

/**
 * create by yifeng
 */
@Service
public class MenuRoleService {

    Logger logger = LoggerFactory.getLogger(MenuRoleMapper.class);

    @Autowired
    MenuRoleMapper menuRoleMapper;

//    public int addMunu(Long rid, Long[] mids) {
//        logger.info("addMenu->id:{},mids:{}", rid, mids);
//        return menuRoleMapper.addMenu(rid, mids);
//    }

    public int updateMenuRole(Long rid, Long[] mids) {
        menuRoleMapper.deleteMenuByRid(rid);
        if (mids.length == 0) {
            return 0;
        }
        return menuRoleMapper.addMenu(rid, mids);
    }

}

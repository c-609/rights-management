package cn.team.service;

import cn.team.bean.Dept;
import cn.team.bean.UGroup;
import cn.team.bean.User;
import cn.team.dto.DeptTree;
import cn.team.mapper.DeptMapper;
import cn.team.mapper.GroupMapper;
import cn.team.mapper.UGroupRoleMapper;
import cn.team.mapper.UGroupUserMapper;
import cn.team.vo.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 用户组 服务类
 *
 * create by yifeng
 */
@Service
public class GroupService {
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    UGroupRoleMapper uGroupRoleMapper;
    @Autowired
    UGroupUserMapper uGroupUserMapper;


    /**
     *  通过用户ID，查询用户组信息
     *
     * @param userId
     * @return
     */
    public List<UGroup> listGroupByUserId(Long userId){
        return groupMapper.selectGroupsByUserId(userId);
    }

    /**
     * 通过用户组id查询 用户组详细信息
     * @param id
     * @return
     */
    public UGroup getById(Integer id) {
        return groupMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean save(UGroup uGroup) {
        uGroup.setCreateTime(LocalDateTime.now());
        return groupMapper.save(uGroup);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean removeGroupById(Integer id) {
        // 删除该用户组关联用户和角色
        uGroupRoleMapper.deleteByUGroupId(id);
        uGroupUserMapper.deleteByUGroupId(id);
        groupMapper.removeById(id);
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean update(UGroup uGroup) {
        return groupMapper.updateById(uGroup);
    }

}


package cn.team.service;

import cn.team.bean.UGroup;
import cn.team.bean.UGroupUser;
import cn.team.bean.User;
import cn.team.mapper.GroupMapper;
import cn.team.mapper.UGroupRoleMapper;
import cn.team.mapper.UGroupUserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 用户组 服务类
 *
 * create by yifeng
 */
@Service
@AllArgsConstructor
public class GroupService {
    GroupMapper groupMapper;
    UGroupRoleMapper uGroupRoleMapper;
    UGroupUserMapper uGroupUserMapper;
    UserService userService;

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
     * 获取用户列表 根据组id
     * @param gid
     * @return
     */
    public List<User> listUserByGid(Integer gid) {
        List<UGroupUser> ugroupUserList = uGroupUserMapper.
                selectList(Wrappers.
                        lambdaQuery(UGroupUser
                                .builder()
                                .uGroupId(gid).build()));
        List<User> users = new ArrayList<>(ugroupUserList.size());
        ugroupUserList.stream().forEach(item -> {
            users.add(userService.findUserById(item.getUserId()));
        });
        return users;
    }

    /**
     * 更新组角色关系
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateGroupRole(Integer groupId, Integer[] roles) {
        uGroupRoleMapper.deleteByUGroupId(groupId);
        uGroupRoleMapper.insertListBygid(groupId, roles);
        return Boolean.TRUE;
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


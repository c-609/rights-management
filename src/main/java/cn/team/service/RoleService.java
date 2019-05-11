package cn.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.bean.Role;
import cn.team.bean.User;
import cn.team.mapper.RoleMapper;

import java.util.List;

/**
 * Created by sang on 2018/1/1.
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> roles() {
        return roleMapper.roles();
    }

    public int addNewRole(String role, String roleZh) {
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        return roleMapper.addNewRole(role, roleZh);
    }

    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    // 更新角色的部门权限
    public int updateDeptAuthForRole (int rid, int[] deptIds) {
        // 先删除角色对应的权限
        deleteDeptAuthForRole(rid);
        return roleMapper.updateDeptAuthForRole(rid, deptIds);
    }

    public int deleteDeptAuthForRole(int rid) {
        return roleMapper.deleteDeptAuthForRole(rid);
    }

    public int deleteRoleById(Long rid) {
        return roleMapper.deleteRoleById(rid);
    }
    
    public List<User> getUserByRoleId(int rid){
    	return roleMapper.findUserByRoleId(rid);
    }

    public List<Role> findRolesByDeptid(int deptId) {
        return roleMapper.findRolesByDeptid(deptId);
    }
}

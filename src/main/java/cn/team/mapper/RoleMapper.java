package cn.team.mapper;

import org.apache.ibatis.annotations.Param;

import cn.team.bean.Role;
import cn.team.bean.User;

import java.util.List;

/**
 * Created by sang on 2018/1/1.
 */
public interface RoleMapper {
    List<Role> roles();
    
    int addNewRole(@Param("role") String role, @Param("roleZh") String roleZh);

    int deleteRoleById(Long rid);
    
    List<User> findUserByRoleId(@Param("rid") int rid);
    
    int updateRole(Role role);
}

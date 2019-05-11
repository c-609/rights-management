package cn.team.service;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.team.bean.Role;
import cn.team.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.bean.User;
import cn.team.mapper.UserMapper;

@Service
@Transactional
public class UserService implements UserDetailsService{
	@Autowired
	UserMapper userMapper;

	@Autowired
	DeptMapper deptMapper;

	@Autowired
	PasswordEncoder passwordEncoder;
//	public User getUserById(int id) {
//		return userMapper.findUserById(id);
//	}
	
	public List<User> getAllUserByPage(Integer page, Integer size, String username){
		int start = (page - 1) * size;
        return userMapper.findUserByPage(start, size, username);
	}
	
	public long getCountByUsername(String username) {
		return userMapper.getCountByUsername(username);
	}
	
	public List<User> getEmployeeByPageShort(Integer page, Integer size) {
	   int start = (page - 1) * size;
	   return userMapper.getUserByPageShort(start,size);
	}
	
	public List<User> getAllUser(){
		return userMapper.findUserList();
	}

	/**
	 * 增加用户的同时，增加对应的角色
	 * @param user
	 * @param rids
	 * @return
	 */
	public Integer addUser(User user, Long rids[]) {
		// 密码加密
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMapper.addUser(user);
		Long uid = getUserIdByUsername(user.getUsername());
		int rowCount = addRolesByUId(uid, rids);
		return rowCount;
	}

	public User getUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}
	public int deleteUserByUId(Long uid) {
		userMapper.deleteRoleByUId(uid);
		return userMapper.deleteUserByUId(uid);
	}

	public int addRolesByUId(Long  UId, Long [] rids) {
		return userMapper.addRolesForUser(UId, rids);
	}

	public int updateRoleForUser(Long uId,Long[] rids) {
		 int i = userMapper.deleteRoleByUId(uId);
	      return userMapper.addRolesForUser(uId, rids);
		
	}

	public Long getUserIdByUsername(String username) {
		return userMapper.findUserIdByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userMapper.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不对");
		}
		return user;
	}

	public List<User> getUserlistByDeptId(int deptId) {
		return deptMapper.getAllUserByDeptId(deptId);
	}

}

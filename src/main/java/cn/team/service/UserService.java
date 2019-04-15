package cn.team.service;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.bean.User;
import cn.team.mapper.UserMapper;

@Service
@Transactional
public class UserService implements UserDetailsService{
	@Autowired
	UserMapper userMapper;
	
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
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
	public User getUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}
	public int deleteUserByUsername(String username) {
		return userMapper.deleteUserByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userMapper.findUserByUsername(username);
		 Collection collection = user.getAuthorities();
	        if (user == null) {
	            throw new UsernameNotFoundException("用户名不对");
	        }
	        //System.out.println(user.getName()+"-----------");
	        return user;
	}
}

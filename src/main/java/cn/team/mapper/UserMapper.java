package cn.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.team.bean.User;

@Mapper
public interface UserMapper {
//	User findUserByUsername(@Param("username") String username);
//	
//	int addUser(@Param("user")User user);//-----------------------
	
	//List<User> findUserByUserame(@Param("name")String name);
	
	User findUserById(@Param("id")int id);
	
	List<User> findUserList();
	
	List<User> findUserByPage(@Param("start") Integer start, @Param("size") Integer size,@Param("username") String username);
	
	List<User> getUserByPageShort(@Param("start") int start, @Param("size") Integer size);

	long getCountByUsername(@Param("username") String username);
	
	int addUser(@Param("user")User user);
	
	User findUserByUsername(@Param("username")String username);

	Long findUserIdByUsername(@Param("username") String username);
	
	int updateUser(@Param("user")User user);
	
	int deleteUserByUId(@Param("id") Long uid);

	int deleteRoleByUId(Long UId);
	
	int addRolesForUser(@Param("uId") Long  uId, @Param("rids") Long [] rids);

	//int updateRoleForUser(@Param("urId") int urId,@Param("rid") int rId);
}

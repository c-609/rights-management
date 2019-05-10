package cn.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.team.bean.Dept;
import cn.team.bean.User;

@Mapper
public interface DeptMapper {
	List<Dept> getAllDept();

	Dept getDeptById(@Param("id") int id);

	int addDept(Dept dept);
	
	int updateDept(Dept dept);
	
	int deleteDeptById(@Param("id") int id);
	
	List<User> getAllUserByDeptId(@Param("id") int id);

	int addRoleForDept(@Param("dId") int dId,@Param("rIds") int[] rIds);

	int deleteRoleByDeptId(@Param("dId") int dId);
}

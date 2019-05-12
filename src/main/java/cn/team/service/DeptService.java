package cn.team.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import cn.team.bean.Dept;
import cn.team.bean.User;
import cn.team.common.beans.ResultBean;
import cn.team.dto.DeptTree;
import cn.team.mapper.DeptMapper;
import cn.team.vo.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeptService {
	 @Autowired
     DeptMapper deptMapper;
	 
	 public List<Dept> list(){
		 return deptMapper.getAllDept();
	 }

	 public Dept getById(Integer id) {
	 	return deptMapper.getDeptById(id);
	 }

	/**
	 * 删除部门和对应的角色
	 * @param id
	 * @return
	 */
    @Transactional(rollbackFor = Exception.class)
	public int deleteDept(int id) {
	 	deptMapper.deleteRoleByDeptId(id);
		 return  deptMapper.deleteDeptById(id);
	 }

    @Transactional(rollbackFor = Exception.class)
	public int updateDept(Dept dept) {
		 return deptMapper.updateDept(dept);
	}

	public List<User> getUserByDeptId(int id){
		 return deptMapper.getAllUserByDeptId(id);
	 }

	/**
	 * 增加部门
	 * @param dept 部门
	 * @return
	 */
    @Transactional(rollbackFor = Exception.class)
	public int save(Dept dept) {
		return deptMapper.addDept(dept);
    }

	/**
	 * 查询全部部门树
	 * @return
	 */
	public List<DeptTree> listDeptTrees() {
    	return getDeptTree(deptMapper.getAllDept());
	}

//	public List<DeptTree> listCurrentUserDeptTrees() {
//		Integer deptId = Security
//	}

	/**
	 * 构建部门树
	 *
	 * @param depts
	 * @return
	 */
	private List<DeptTree> getDeptTree(List<Dept> depts) {
    	List<DeptTree> treeList = depts.stream()
			.filter(dept -> !dept.getId().equals(dept.getParentId()))
			.map(dept -> {
				DeptTree node = new DeptTree();
				node.setId(dept.getId());
				node.setParentId(dept.getParentId());
				node.setName(dept.getName());
				return node;
			}).collect(Collectors.toList());
    	return TreeUtil.buildByLoop(treeList, -1);
	}

	/**
	 * 根据角色id查询 部门列表
	 * @param roleId
	 * @return
	 */
	public List<Dept> findDeptsByRoleid(int roleId) {
		return deptMapper.findDeptsByRoleid(roleId);
	}

}


package cn.team.controller.upms;

import cn.team.bean.Dept;
import cn.team.common.beans.ResultBean;
import cn.team.service.DeptService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/upms/dept")
public class UpmsDeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 通过id查询
     * @param id ID
     * @return
     */
    @RequestMapping("/{id}")
    public ResultBean getById(@PathVariable Integer id) {
        return new ResultBean(deptService.getById(id));
    }

    /**
     * 返回树形部门集合
     * @return 部门树
     */
    @RequestMapping("/tree")
    public ResultBean listDeptTrees() {
        return new ResultBean(deptService.listDeptTrees());
    }

    /**
     * 返回角色的部门列表
     * @param roleId
     * @return
     */
    @GetMapping(value = "/list/{roleId}")
    @ResponseBody
    public ResultBean getRoleIdByDepts(@PathVariable Integer roleId) {
        // 转换成id数组返回给前端
        List<Dept> deptList = deptService.findDeptsByRoleid(roleId);
        var resultList = new ArrayList<Integer>(deptList.size());
        deptList.stream().forEach(node -> {
            resultList.add(node.getId());
        });
        return new ResultBean(resultList);
    }

    /**
     * 添加
     * @param dept
     * @return
     */
    @RequestMapping(value = "/dept_add", method = RequestMethod.POST)
    @PreAuthorize("@pms.hasPermission('upms_dept_add')")
    public ResultBean save(@Valid @RequestBody Dept dept) {
        return new ResultBean(deptService.save(dept));
    }

    /**
     * 删除
     * @param id
     * @return 1 / 0
     */
    @PostMapping("/dept_delete")
    @PreAuthorize("@pms.hasPermission('upms_dept_delete')")
    public ResultBean delete(Integer id) {
        return new ResultBean(deptService.deleteDept(id));
    }

    /**
     * 编辑部门
     * @param dept
     * @return
     */
    @PostMapping("dept_update")
    @PreAuthorize("@pms.hasPermission('upms_dept_update')")
    public ResultBean update(@Valid @RequestBody Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        return new ResultBean(deptService.updateDept(dept));
    }

}

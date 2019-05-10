package cn.team.controller.upms;

import cn.team.bean.Dept;
import cn.team.common.beans.ResultBean;
import cn.team.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

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
     * 返回树形菜单集合
     * @return 树形菜单
     */
    @RequestMapping("/tree")
    public ResultBean listDeptTrees() {
        return new ResultBean(deptService.listDeptTrees());
    }

    /**
     * 返回当前用户树形菜单集合
     * @return 树形菜单
     */
//    @RequestMapping("/user-tree")
    public ResultBean listCurrentUserDeptTrees() {
        return new ResultBean();
    }

    /**
     * 添加
     * @param dept
     * @return
     */
    @RequestMapping(value = "/dept_add", method = RequestMethod.POST)
    public ResultBean save(@Valid @RequestBody Dept dept) {
        return new ResultBean(deptService.save(dept));
    }

    /**
     * 删除
     * @param id
     * @return 1 / 0
     */
    @PostMapping("/dept_delete")
    public ResultBean delete(Integer id) {
        return new ResultBean(deptService.deleteDept(id));
    }

    /**
     * 编辑部门
     * @param dept
     * @return
     */
    @PostMapping("dept_update")
    public ResultBean update(@Valid @RequestBody Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        return new ResultBean(deptService.updateDept(dept));
    }

}

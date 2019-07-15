package cn.team.controller.upms;

import cn.team.bean.Role;
import cn.team.common.beans.ResultBean;
import cn.team.controller.RegLoginController;
import cn.team.service.MenuRoleService;
import cn.team.service.RoleService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/upms/role")
public class UpmsRoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuRoleService menuRoleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean getAllRole() {
        return new ResultBean(roleService.roles());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('upms_role_add')")
    public ResultBean addRole(String role, String roleZh) {
        return new ResultBean(roleService.addNewRole(role, roleZh));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('upms_role_delete')")
    public ResultBean deleteRole(Long rid) {
        return new ResultBean(roleService.deleteRoleById(rid));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('upms_role_update')")
    public ResultBean updateRole(Role role) {
        return new ResultBean(roleService.updateRole(role));
    }

    /**
     * 为角色授权
     * @param rid
     * @param mids
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("@pms.hasPermission('upms_role_menu_auth')")
    public ResultBean setRoleAuth(Long rid, Long[] mids) {
        return new ResultBean(menuRoleService.updateMenuRole(rid, mids));
    }

    /**
     * 根据部门id获取角色列表
     * @param deptId
     * @return
     */
    @RequestMapping(value = "/{deptId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean getDeptIdByRoles(@PathVariable int deptId) {
        return new ResultBean(roleService.findRolesByDeptid(deptId));
    }


    /**
     * 为角色赋予部门权限
     * TODO 菜单中未添加该权限
     * @param rid 角色id
     * @param deptIds 部门id列表
     * @return
     */
    @PostMapping("/deptAuthForRole")
    @PreAuthorize("@pms.hasPermission('upms_role_dept_auth')")
    public ResultBean deptAuthForRole(int rid, int[] deptIds) {
        return new ResultBean(roleService.updateDeptAuthForRole(rid, deptIds));
    }

}

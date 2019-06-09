package cn.team.controller.upms;

import cn.team.bean.UGroup;
import cn.team.common.beans.ResultBean;
import cn.team.common.util.UserUtil;
import cn.team.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/upms/group")
public class UpmsGroupController {

    @Autowired
    private GroupService groupService;

    /**
     *  返回当前用户的用户组集合
     * @return
     */
    @GetMapping
    public ResultBean getUGroupUser() {
        return new ResultBean(groupService.listGroupByUserId(UserUtil.getCurrentUser().getId()));
    }

    /**
     * 通过id查询用户组的详细信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultBean getById(@PathVariable Integer id) {
        return new ResultBean(groupService.getById(id));
    }

    /**
     * 新增用户组
     * @param uGroup
     * @return
     */
    @PostMapping
    @PreAuthorize("@pms.hasPermission('upms_u_group_add')")
    public ResultBean save(@Valid @RequestBody UGroup uGroup) {
        return new ResultBean(groupService.save(uGroup));
    }

    /**
     * 删除用户组
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('upms_u_group_del')")
    public ResultBean removeById(@PathVariable Integer id) {
        return new ResultBean(groupService.removeGroupById(id));
    }

    /**
     * 更新用户组
     * @param uGroup
     * @return
     */
    @PutMapping
    @PreAuthorize("@pms.hasPermission('upms_u_group_edit')")
    public ResultBean update(@Valid @RequestBody UGroup uGroup) {
        return new ResultBean(groupService.update(uGroup));
    }

    /**
     * 更具组角色
     * @return
     */
    @PutMapping("/group")
    @PreAuthorize("@pms.hasPermission('upms_u_group_perm')")
    public ResultBean saveGroupRole(Integer groupId, Integer[] roleIds) {
        return new ResultBean(groupService.updateGroupRole(groupId, roleIds));
    }


}

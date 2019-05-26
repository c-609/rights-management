package cn.team.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 用户组管理
 *
 * create by yifeng
 */
@Data
public class UGroup {

    private int id;
    /**
     * 用户组名称
     */
    @NotBlank(message = "用户组名称不能为空")
    private String name;
    /**
     * 用户组排序
     */
    private int sort;

//    @NotBlank(message = "用户组父id不能为空")
    private int parentId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    /**
     * 是否删除 1: 已删除 0：正常
     */
    private String delFlag;

}

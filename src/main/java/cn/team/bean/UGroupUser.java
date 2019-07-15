package cn.team.bean;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 用户组用户表
 *
 * create by yifeng
 */
@Data
@Builder
public class UGroupUser {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户组id
     */
    private Integer uGroupId;
}

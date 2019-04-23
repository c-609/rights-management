package cn.team.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 关于 @EqualsAndHashCode 注解可参考以下地址
 * https://blog.csdn.net/zhanlanmg/article/details/50392266
 * create by yifeng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends TreeNode {

    private String url;
    private String path;
    private Object component;
    private String name;
    private String iconCls;

}

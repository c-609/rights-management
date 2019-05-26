package cn.team.dto;

import cn.team.bean.Dept;
import cn.team.bean.Menu;
import cn.team.bean.Role;
import cn.team.bean.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 *
 * 考虑到目前User耦合的太严重，需要解耦
 * 耦合表现在 部门和角色部分，这里抽出在这个类中,后面还需优化
 *
 * create by yifeng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends User {

    private List<Integer> role;

    private List<Integer> dept;

}

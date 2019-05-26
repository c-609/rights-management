package cn.team.mapper;

import cn.team.bean.UGroup;
import cn.team.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by yifeng
 */
@Mapper
public interface UGroupUserMapper {

    int insertListByuid(Integer uid, int[] gids);

    int insertListBygid(Integer gid, int[] uids);

    boolean deleteByUserId(Integer uid);

    boolean deleteByUGroupId(Integer gid);

}

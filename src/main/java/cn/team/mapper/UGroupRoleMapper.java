package cn.team.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * create by yifeng
 */
@Mapper
public interface UGroupRoleMapper {

    int insertListByrid(Integer rid, int[] gids);

    int insertListBygid(Integer gid, Integer[] rids);

    boolean deleteByrid(Integer rid);

    boolean deleteByUGroupId(Integer gid);
}

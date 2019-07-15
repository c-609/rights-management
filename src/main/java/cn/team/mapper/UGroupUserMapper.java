package cn.team.mapper;

import cn.team.bean.UGroup;
import cn.team.bean.UGroupUser;
import cn.team.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by yifeng
 */
@Mapper
public interface UGroupUserMapper extends BaseMapper<UGroupUser> {

    int insertListByuid(Integer uid, int[] gids);

    int insertListBygid(Integer gid, int[] uids);

    boolean deleteByUserId(Integer uid);

    boolean deleteByUGroupId(Integer gid);

}

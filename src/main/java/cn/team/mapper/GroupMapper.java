package cn.team.mapper;

import cn.team.bean.UGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by yifeng
 */
@Mapper
public interface GroupMapper {

    /**
     * 通过用户ID， 查询组信息
     *
     * @param UserId
     * @return
     */
    List<UGroup> selectGroupsByUserId(Long UserId);

    UGroup getById(Integer id);

    boolean save(UGroup group);

    boolean updateById(@Param("group") UGroup group);

    boolean removeById(Integer id);
}

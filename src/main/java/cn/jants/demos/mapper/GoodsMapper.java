package cn.jants.demos.mapper;

import cn.jants.common.annotation.service.Mapper;
import cn.jants.common.bean.JsonMap;
import cn.jants.demos.entity.User;

import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-01-17
 */
@Mapper
public interface GoodsMapper {

    JsonMap selectById();

    List<User> selectList();

    User select();

    void deleteById(Long id);
}

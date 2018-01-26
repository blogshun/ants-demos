package cn.jants.demos.mapper;

import cn.jants.common.bean.JsonMap;
import cn.jants.demos.entity.User;
import cn.jants.plugin.sqlmap.annotation.Mapper;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-01-17
 */
@Mapper
public interface GoodsMapper {

    User selectById(Long id);

    JsonMap selectList();

}

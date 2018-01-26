package cn.jants.demos;


import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.Param;
import cn.jants.common.annotation.action.PathVariable;
import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableEhcachePlugin;
import cn.jants.common.annotation.plugin.EnableRedisPlugin;
import cn.jants.common.annotation.plugin.EnableSQLMapPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Source;
import cn.jants.common.bean.JsonMap;
import cn.jants.common.bean.Page;
import cn.jants.core.startup.JTomcat;
import cn.jants.demos.entity.User;
import cn.jants.demos.mapper.GoodsMapper;
import cn.jants.plugin.db.Db;
import cn.jants.plugin.orm.enums.OrderBy;
import cn.jants.plugin.sqlmap.Paging;
import cn.jants.restful.render.Json;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Tomcat 方式启动
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application
@PropertyConfiguration(debug = true)
@EnableEhcachePlugin("ehcache.xml")
@EnableRedisPlugin
@EnableSQLMapPlugin(value = "/sql", hump = true)
@Controller
public class DemosApplication {

    @Source
    private Db db;

    @Autowired
    private GoodsMapper goodsMapper;

    @GET("/test/{id}")
    public Map test(@PathVariable Long id) {
        User jsonMaps = goodsMapper.selectById(id);
        return Json.success(jsonMaps);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JTomcat.run(DemosApplication.class, 80);
    }
}

package cn.jants.demos;


import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.PathVariable;
import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableActiveMQPlugin;
import cn.jants.common.annotation.plugin.EnableEhcachePlugin;
import cn.jants.common.annotation.plugin.EnableRedisPlugin;
import cn.jants.common.annotation.plugin.EnableSQLMapPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Source;
import cn.jants.core.context.AppConfiguration;
import cn.jants.core.startup.JTomcat;
import cn.jants.demos.entity.User;
import cn.jants.demos.mapper.GoodsMapper;
import cn.jants.plugin.db.Db;
import cn.jants.restful.render.Json;

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
public class DemosApplication extends AppConfiguration {

    @Source
    private Db db;

    @Autowired
    private GoodsMapper goodsMapper;

    @GET("/test/{id}")
    public Map test(@PathVariable Long id) {
        User jsonMaps = goodsMapper.selectById(id);
        return Json.success(jsonMaps);
    }

    @GET("/test")
    public Map testOk() {
        return Json.success("ok");
    }

    public static void main(String[] args) {
        JTomcat.run(DemosApplication.class, 80);
    }
}

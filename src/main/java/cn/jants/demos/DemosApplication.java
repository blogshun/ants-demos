package cn.jants.demos;


import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.POST;
import cn.jants.common.annotation.action.PUT;
import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableEhcachePlugin;
import cn.jants.common.annotation.plugin.EnableRedisPlugin;
import cn.jants.common.annotation.plugin.EnableSQLMapPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.common.annotation.service.Source;
import cn.jants.core.startup.JTomcat;
import cn.jants.demos.entity.User;
import cn.jants.plugin.db.Db;
import com.alibaba.fastjson.JSON;

import java.util.List;

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
@EnableSQLMapPlugin("/sql")
@Controller
public class DemosApplication {

    @Source
    private Db db;

    @PUT("/test")
    public Object test(User user) {
        System.out.println(JSON.toJSONString(user));
        List list = db.findList("Student.testInclude");
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        JTomcat.run(DemosApplication.class, 80);
    }
}

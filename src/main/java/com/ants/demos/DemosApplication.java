package com.ants.demos;


import com.ants.common.annotation.boot.PropertyConfiguration;
import com.ants.common.annotation.plugin.EnableEhcachePlugin;
import com.ants.common.annotation.plugin.EnableRedisPlugin;
import com.ants.common.annotation.service.Application;
import com.ants.core.startup.JTomcat;

/**
 * Tomcat 方式启动
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application(scanPackages = "com.ants.demos")
@PropertyConfiguration
@EnableEhcachePlugin("ehcache.xml")
@EnableRedisPlugin
public class DemosApplication {

    public static void main(String[] args) {
        JTomcat.run(DemosApplication.class, 80);
    }
}

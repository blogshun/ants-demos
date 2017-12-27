package com.ants.demos;


import com.ants.common.annotation.boot.PropertyConfiguration;
import com.ants.common.annotation.plugin.EnableEhcachePlugin;
import com.ants.common.annotation.plugin.EnableRedisPlugin;
import com.ants.common.annotation.service.Application;
import com.ants.common.bean.Prop;
import com.ants.core.context.AntsTool;
import com.ants.core.startup.JTomcat;
import com.ants.plugin.cache.EhCacheTpl;
import com.ants.plugin.cache.RedisTpl;
import com.ants.plugin.jms.ActiveMqTpl;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

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

    public static void main(String[] args) throws InterruptedException {
       // JTomcat.run(DemosApplication.class, 80);
        Prop.use("application.properties");
        AntsTool.getAliOss("http://ants-m.oss-cn-beijing.aliyuncs.com", "LTAIGtncqJ1CaDvW", "z6RtuvVSFqcCnn3rsYT6z4L9RcwWZH");
    }
}

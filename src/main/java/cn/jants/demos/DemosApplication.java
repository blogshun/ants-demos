package cn.jants.demos;


import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableEhcachePlugin;
import cn.jants.common.annotation.plugin.EnableRedisPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.common.bean.Prop;
import cn.jants.plugin.tool.AliOssTool;

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
        AliOssTool.getAliOss("http://ants-m.oss-cn-beijing.aliyuncs.com", "LTAIGtncqJ1CaDvW", "z6RtuvVSFqcCnn3rsYT6z4L9RcwWZH");
    }
}

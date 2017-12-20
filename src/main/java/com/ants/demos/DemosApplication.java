package com.ants.demos;


import com.ants.common.annotation.service.Application;
import com.ants.core.startup.Jetty;

/**
 * Tomcat 方式启动
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application(scanPackages = "com.ants.demos")
//@PropertyConfiguration(value = "config.properties"
//        , suffix = ".do"
//        , resources="/static/"
//        , page404 = "404.html"
//        , page500 = "500.html"
//        , debug = true
//        , encoding = "utf-8")
//@DbConfiguration(dbs = {
//        @DbSource(""),
//        @DbSource(""),
//        @DbSource("")
//})
public class DemosApplication {

    public static void main(String[] args) {
        //第一个参数配置类
        //第二个参数端口
        //第三个参数是否打开浏览器调试
        Jetty.run(DemosApplication.class, 80);
    }
}

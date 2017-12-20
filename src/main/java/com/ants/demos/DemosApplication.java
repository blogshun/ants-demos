package com.ants.demos;


import com.ants.common.annotation.boot.PropertyConfiguration;
import com.ants.common.annotation.service.Application;
import com.ants.core.startup.JTomcat;

/**
 * Tomcat 方式启动
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application
@PropertyConfiguration
public class DemosApplication {

    public static void main(String[] args) {
        //第一个参数配置类
        //第二个参数端口
        //第三个参数是否打开浏览器调试
        JTomcat.run(DemosApplication.class, 80, true);
    }
}

package com.ants.demos;


import com.alibaba.fastjson.JSON;
import com.ants.common.annotation.action.Controller;
import com.ants.common.annotation.action.GET;
import com.ants.common.annotation.plugin.EnableEhcachePlugin;
import com.ants.common.annotation.service.Application;
import com.ants.common.annotation.service.Autowired;
import com.ants.core.startup.Jetty;
import com.ants.plugin.cache.Cacheable;
import com.ants.plugin.cache.EhCacheTpl;

/**
 * Tomcat 方式启动
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application(scanPackages = "com.ants.demos")
@EnableEhcachePlugin("ehcache.xml")
@Controller("/ehcache")
public class DemosApplication {

    @Autowired
    private EhCacheTpl tpl;

    /**
     * 保存缓存
     *
     * @return
     */
    @GET("/save")
    public Object save() {
        tpl.put("app", "ants is ok!");
        return "ants ehcache save is ok!";
    }

    /**
     * 查询缓存
     *
     * @return
     */
    @GET("/get")
    public Object get() {
        System.out.println(tpl.get("app"));
        return "ants ehcache get is ok!";
    }

    /**
     * 清除默认缓存组所有key
     *
     * @return
     */
    @GET("/clear")
    public Object clear() {
        tpl.getCache().removeAll();
        return "ants ehcache clear is ok!";
    }

    /**
     * 查询ehcache默认缓存组所有key
     *
     * @return
     */
    @GET("/keys")
    public Object keys() {
        System.out.println(JSON.toJSONString(tpl.getKeys()));
        return "ants ehcache keys is ok!";
    }

    /**
     * 注解式缓存
     *
     * @return
     */
    @GET("/anno")
    @Cacheable
    public Object anno() {
        System.out.println("测试看看是否被缓存了");
        return "ants ehcache keys is ok!";
    }

    public static void main(String[] args) {
        Jetty.run(DemosApplication.class, 80);
    }
}

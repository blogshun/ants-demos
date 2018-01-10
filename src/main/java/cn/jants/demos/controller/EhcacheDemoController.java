package cn.jants.demos.controller;

import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.plugin.cache.CacheEvict;
import cn.jants.plugin.cache.Cacheable;
import cn.jants.plugin.cache.EhCacheTpl;
import com.alibaba.fastjson.JSON;

/**
 * Ehcache Demo
 * 需要在启动类配置@EnableEhcachePlugin注解
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/21
 */
@Controller("/ehcache")
public class EhcacheDemoController {


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
     * 注解式存储缓存
     *
     * @return
     */
    @GET("/cacheable")
    @Cacheable
    public Object cache() {
        System.out.println("测试看看是否被缓存了");
        return "ants ehcache cache is ok!";
    }

    /**
     * 注解式清除缓存
     *
     * @return
     */
    @GET("/evict")
    @CacheEvict
    public Object evict() {
        return "ants ehcache evict is ok!";
    }
}

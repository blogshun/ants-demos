package cn.jants.demos.controller;

import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.Param;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.plugin.cache.RedisTpl;

/**
 * Redis Demo
 * 需要在启动类配置@EnableRedisPlugin注解
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/21
 */
@Controller("/redis")
public class RedisDemoController {

    @Autowired
    private RedisTpl redisTpl;

    /**
     * 存入缓存
     */
    @GET("/put")
    public void put() {
        redisTpl.set("keywords", "这是一个搜索关键词");
    }

    /**
     * 取缓存
     *
     * @param key
     * @return
     */
    @GET("/get")
    public Object get(@Param String key) {
        return redisTpl.getStr(key);
    }
}

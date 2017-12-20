package com.ants.demos.controller;

import com.alibaba.fastjson.JSON;
import com.ants.common.annotation.action.*;
import com.ants.common.bean.Log;
import com.ants.common.enums.Regex;
import com.ants.demos.entity.User;

import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Restful案例demo
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Controller("/restful")
public class RestfulDemoController {


    /**
     * GET请求
     *
     * @param name 可选参数
     * @return
     */
    @GET("/get")
    public Object get(String name) {
        return "test param binging ".concat(name).concat(" is ok!");
    }

    /**
     * POST请求, 自动组装实体
     *
     * @param user 必须是application/json
     * @return
     */
    @POST("/post")
    public Object post(User user) {
        Log.debug("user:" + user);
        String userJson = JSON.toJSONString(user);
        Log.debug("userJson:" + userJson);
        return "test entity binging ".concat(userJson).concat(" is ok!");
    }

    /**
     * PUT请求
     *
     * @param id url参数
     * @return
     */
    @PUT("/put/{id}")
    public Object put(@PathVariable Long id) {
        return "ants put is ok!";
    }

    /**
     * DELETE请求
     *
     * @param id 必传参数, 支持正则校验, 与错误提示
     * @return
     */
    @DELETE("/delete")
    public Object delete(@Param(type = Regex.CODE, msg = "ID不能为空!") Long id) {
        return "ants delete is ok!";
    }

    /**
     * 文件上传, form-data
     *
     * @param part
     * @param name
     * @return
     * @throws IOException
     */
    @POST("/part")
    public Object part(Part part, String name) throws IOException {
        return "ants file upload is ok!";
    }
}

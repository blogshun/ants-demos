package com.ants.demos.controller;

import com.ants.common.annotation.action.*;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Controller("/restful")
public class RestfulDemoController {


    @GET("/get")
    public Object get(){
        return "ants get is ok!";
    }

    @POST("/post")
    public Object post(){
        return "ants post is ok!";
    }

    @PUT("/put")
    public Object put(){
        return "ants put is ok!";
    }

    @DELETE("/delete")
    public Object delete(){
        return "ants delete is ok!";
    }
}

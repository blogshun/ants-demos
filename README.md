# Ants框架Demo案例
Ants框架常用的一些Demo例子，以及其他插件...

#### 文档目录

- [Jetty、Tomcat启动](./README.md#Jetty、Tomcat启动)
- [注解介绍](./README.md#注解介绍)
- [加载类注解](./README.md#加载类注解)
- [Restful](./README.md#Restful)
- [参数绑定以及校验](./README.md#参数绑定以及校验)
- [插件](./README.md#插件)
	- [Template模板引擎插件](./README.md#Template模板引擎插件)
	- [ORMCriteria](./README.md#ORMCriteria)
	- [SqlMap](./README.md#SqlMap)
	- [Scheduler任务调度](./README.md#Scheduler任务调度)
	- [Db操作](./README.md#Db操作)
	- [ActiveMq队列](./README.md#ActiveMq队列)
	- [Redis缓存](./README.md#Redis缓存)
	- [Ehcache缓存](./README.md#Ehcache缓存)
- [代码生成器](./README.md#项目构建)
- [联系作者](./README.md#联系作者)

# Jetty、Tomcat启动

**Jetty 启动**

需要添加如下依赖, 推荐版本8.1.7.v20120910

```xml
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-server</artifactId>
    <version>8.1.7.v20120910</version>
</dependency>
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-webapp</artifactId>
    <version>8.1.7.v20120910</version>
</dependency>
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-jsp</artifactId>
    <version>8.1.7.v20120910</version>
</dependency
```

**代码案例**
```java
package com.ants.demos;


import com.ants.common.annotation.service.Application;
import com.ants.core.startup.Jetty;

/**
 * Jetty 方式启动
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application
public class DemosApplication {

    public static void main(String[] args) {
        //第一个参数配置类
        //第二个参数端口
        //第三个参数是否打开浏览器调试
        Jetty.run(DemosApplication.class, 80, true);
    }
}
```


**Tomcat 启动**

需要添加如下依赖, 推荐版本8.0.28, 其他websocket功能扩展还需要添加相应maven依赖

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-core</artifactId>
    <version>8.0.28</version>
</dependency>
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-logging-juli</artifactId>
    <version>8.0.28</version>
</dependency>
```

**代码案例**
```java
package com.ants.demos;


import com.ants.common.annotation.service.Application;
import com.ants.core.startup.JTomcat;

/**
 * Tomcat 方式启动
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application
public class DemosApplication {

    public static void main(String[] args) {
        //第一个参数配置类
        //第二个参数端口
        //第三个参数是否打开浏览器调试
        JTomcat.run(DemosApplication.class, 80, true);
    }
}

```


# 注解介绍

### 启动注解（只能用在启动类上）

| 注解         |  描述  |
| ------------- | -----|
| @Application | 标识启动类 |
| @PropertyConfiguration| 属性配置, 包括配置文件|
| @DbConfiguration  | 多数据源配置 |
| @DbSource  | 数据源对象|
| @ViewConfiguration  | 视图模板配置 |
| @EnableActiveMQPlugin  | 开启ActiveMQ插件|
| @EnableEhcachePlugin  | 开启Ehcache插件 |
| @EnableRedisPlugin  | 开启Redis插件|
| @EnableSQLMapPlugin  | 开启SqlMap插件 |

### Restful注解

| 注解         |  描述  |
| ------------- | -----|
| @Controller | 标识控制器类 |
| @DELETE、@POS、@GET、@PUT | restful请求标注 |
| @Param  | 参数绑定, 该注解表示参数必传 |
| @PathVariable  | url参数绑定到方法参数 |
| @Entity  | 标注类为实体类, 可以自动接收Request参数 |

### 插件注解

| 注解         |  描述  |
| ------------- | -----|
| @FixedDelay | Scheduler插件, 任务调度类注解设置调度时间 |
| @Column | Orm插件标, 注实体类, 属性对应数据库字段 |
| @Id  | Orm插件标, 标注主键 |
| @Table | Orm插件标, 标注数据库表名称 |
| @JmsListener  | AcitveMq插件, 标注消费者监听类 |
| @Cacheable  | Ehcache插件, 存储对象到缓存 |
| @CacheEvict  | Ehcache插件, 标注方法清空缓存 |
| @CachePut  | Ehcache插件, 标注方法更新缓存 |

### 其他注解

| 注解         |  描述  |
| ------------- | -----|
| @Aop | 标注先执行拦截器 |
| @Uop | 标注解除拦截器拦截 |
| @Service  | 标注对象实例化为单例对象 |
| @Autowired | 构造注入@Service标注的对象 |
| @Value  | 注入内存配置文件属性, 等价于 `Prop.get()` |
| @Tx  | 标注该方法开始事务, 支持多数据源回滚 |
| @Source  | 标注类中该属性是属于数据库操作类 |


# 加载类注解
**代码案例**
```java
package com.ants.demos;


import com.ants.common.annotation.service.Application;
import com.ants.core.startup.JTomcat;

/**
 * Tomcat 方式启动
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application
public class DemosApplication {

    public static void main(String[] args) {
        //第一个参数配置类
        //第二个参数端口
        //第三个参数是否打开浏览器调试
        JTomcat.run(DemosApplication.class, 80, true);
    }
}

```


# Restful
**代码案例**
```java
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

```


# 参数绑定以及校验

````java
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

````

# 插件

# Template模板引擎插件

# ORMCriteria

# SqlMap

# Scheduler任务调度

# Db操作

# ActiveMq队列

# Redis缓存

# Ehcache缓存


# 代码生成器

# 联系作者
QQ:358113099

WeChat：BlackWhite0725

Email:shun-blog@qq.com

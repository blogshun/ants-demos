# Ants框架Demo案例
Ants框架常用的一些Demo例子，以及其他插件...

#### 文档目录

- [Jetty、Tomcat启动](./README.md#Jetty&Tomcat启动)
- [注解介绍](./DOC.md#mvc)

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


# 联系作者
QQ:358113099

WeChat：BlackWhite0725

Email:shun-blog@qq.com

package cn.jants.demos;


import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.PUT;
import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableEhcachePlugin;
import cn.jants.common.annotation.plugin.EnableRedisPlugin;
import cn.jants.common.annotation.plugin.EnableSQLMapPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Source;
import cn.jants.common.bean.JsonMap;
import cn.jants.demos.entity.User;
import cn.jants.demos.mapper.GoodsMapper;
import cn.jants.plugin.db.Db;

import java.lang.reflect.*;
import java.util.List;

/**
 * Tomcat 方式启动
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Application
@PropertyConfiguration(debug = true)
@EnableEhcachePlugin("ehcache.xml")
@EnableRedisPlugin
@EnableSQLMapPlugin("/sql")
@Controller
public class DemosApplication {

    @Source
    private Db db;

    @Autowired
    private GoodsMapper goodsMapper;

    @PUT("/test")
    public Object test(User user) {
        JsonMap jsonMap = goodsMapper.selectById();
        return jsonMap;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        SerializerFeature[] features = new SerializerFeature[] {
//                SerializerFeature.WriteEnumUsingName,
//                //SerializerFeature.SkipTransientField,
//                //SerializerFeature.DisableCircularReferenceDetect
//        };
        User user = new User();
        user.setName("张三");
        user.setId(1L);
        user.setSex("女");
////        user.put("pos", "开发工程师");
////        user.put("isLock", 1);
//        user.setSx(Sex.BOY);
//        System.out.println(JSON.toJSONString(user));
        //JTomcat.run(DemosApplication.class, 80);

        Field[] fields = user.getClass().getDeclaredFields();

        for (Field f : fields) {
            if (f.getType() == java.util.List.class) {
                f.setAccessible(true);
                // 如果是List类型，得到其Generic的类型
                Type genericType = f.getGenericType();
                if (genericType == null) {
                    continue;
                }
                // 如果是泛型参数的类型
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) genericType;
                    //得到泛型里的class类型对象
                    Class<?> genericClazz = (Class<?>) pt.getActualTypeArguments()[0];
                    System.out.println(genericClazz);
                }
            }
        }
    }
}

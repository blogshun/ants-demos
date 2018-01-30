package cn.jants.demos.Interceptor;

import cn.jants.common.bean.Invocation;
import cn.jants.core.ext.Interceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * @author MrShun
 * @version 1.0
 */
public class TestInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invo) throws InvocationTargetException, IllegalAccessException {
        System.out.println("哈哈");
        return invo.invoke();
    }
}

package 静态代理JDKCGlib动态代理;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午4:21
 */
public class TargetInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB 调用前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB 调用后");
        return result;
    }
}

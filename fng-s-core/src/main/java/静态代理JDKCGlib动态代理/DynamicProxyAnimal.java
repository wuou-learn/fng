package 静态代理JDKCGlib动态代理;

import java.lang.reflect.Proxy;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午3:57
 */
public class DynamicProxyAnimal {

    public static Object getProxy(Object target){
        return  Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TargetInvoker(target)
        );
    }
}

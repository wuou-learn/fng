package 静态代理JDKCGlib动态代理;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午4:23
 */
public class CglibProxy {
    
    public static Object getProxy(Class<?> proxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(proxy.getClass().getClassLoader());
        enhancer.setSuperclass(proxy);
        enhancer.setCallback(new TargetInterceptor());
        return enhancer.create();
    }
}

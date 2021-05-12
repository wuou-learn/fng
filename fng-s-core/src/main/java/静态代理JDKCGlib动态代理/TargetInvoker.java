package 静态代理JDKCGlib动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午3:50
 */
public class TargetInvoker implements InvocationHandler {
    
    // 代理中持有的目标类
    private Object target;

    public TargetInvoker(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk 代理执行前");
        Object result = method.invoke(target, args);
        System.out.println("jdk 代理执行后");
        return result;
    }
}

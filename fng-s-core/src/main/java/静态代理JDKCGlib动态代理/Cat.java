package 静态代理JDKCGlib动态代理;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午3:43
 */
public class Cat implements Animal{
    
    @Override
    public void call() {
        System.out.println("喵~");
    }
}

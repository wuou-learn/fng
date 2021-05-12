package 静态代理JDKCGlib动态代理;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午4:14
 */
public class Dog implements Animal{
    @Override
    public void call() {
        System.out.println("汪汪汪~");
    }
}

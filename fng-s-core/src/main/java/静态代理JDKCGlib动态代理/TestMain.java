package 静态代理JDKCGlib动态代理;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午3:47
 */
public class TestMain {

    public static void main(String[] args) {
        /*Cat cat = new Cat();

        Animal proxy = (Animal) DynamicProxyAnimal.getProxy(cat);
        
        proxy.call();

        Animal proxy1 =(Animal) CglibProxy.getProxy(Dog.class);
        
        proxy1.call();*/
        
        int i = 2;
        
        for (int j = 0; j<10 ;j++){
            i = i++;
        }
        
        System.out.println(i);
    }
}

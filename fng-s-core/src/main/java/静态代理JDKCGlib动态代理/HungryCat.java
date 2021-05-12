package 静态代理JDKCGlib动态代理;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/4 下午3:44
 */

public class HungryCat implements Animal{
    
    private Animal animal;
    
    public HungryCat(Animal animal){
        this.animal = animal;
    }
    
    @Override
    public void call() {
        System.out.println("饿了~");
        animal.call();
    }

}

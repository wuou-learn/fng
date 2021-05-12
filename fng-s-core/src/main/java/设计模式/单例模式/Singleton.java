package 设计模式.单例模式;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/11/11 下午2:48
 */
public class Singleton {

    private Singleton() {

    }

    /**
     * 静态内部类保证了 只在类加载的时候进行初始化 Singleton对象
     * 保证了线程安全：类的静态属性只会在第一次加载类的时候初始化，
     * 在类的初始化时，别的线程是进不去的
     * 实现了懒加载，在第一次调用该方法的时候 内部类才进行加载
     */
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public synchronized static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

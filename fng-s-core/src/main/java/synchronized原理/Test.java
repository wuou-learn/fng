package synchronized原理;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/12/25 上午9:27
 */
public class Test {
    
    private static int a = 1;
    
    public synchronized int add(){
        return a++;
    }
    
    public int add2(){
        synchronized (this){
            return a++;
        }
    }
}

package Future源码;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/12/11 下午2:30
 */
public final class FutureTest {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
        
        HashMap hashMap = new HashMap();
        hashMap.put(null,"ss");
        hashMap.put(null,"aa");
        System.out.println(hashMap.get(null));
        
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.tryLock();
        reentrantLock.unlock();
        synchronized (new Object()){
            
        }
        AtomicReference atomicReference = new AtomicReference<>();

        Collections.synchronizedMap(new HashMap<>());
        
    }
}

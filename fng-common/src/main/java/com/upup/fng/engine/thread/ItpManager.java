package com.upup.fng.engine.thread;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/3/4 上午9:25
 */
@Component
public class ItpManager {
    /** 线程池集合 */
    private static final Map<String, ExecutorService> _pools = new HashMap<>();


    public static void post(ItpRunnableM task){
        ExecutorService pool = getPool("cached");
        pool.execute(task);
    }

    public synchronized static ExecutorService getPool(String type){
        ExecutorService pool = _pools.get("main-server");
        if(pool==null){
            //创建cached类型的线程池
            pool = Executors.newCachedThreadPool();
            _pools.put("main-server", pool);
        }
        return pool;
    }

}

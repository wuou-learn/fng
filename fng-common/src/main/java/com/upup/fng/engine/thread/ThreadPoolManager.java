package com.upup.fng.engine.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/11/16 上午9:49
 */
public class ThreadPoolManager {
    
    // 用单例模式对线程进行管理
    private static volatile ThreadPoolExecutor singleTon = null;

    // 获取可用CPU数量
    private static final int CPU_NUM = Runtime.getRuntime().availableProcessors();

    // 以 CPU 密集型为例
    private static final int CORE_POOL_SIZE = CPU_NUM + 1;

    // 设置最大线程数等于核心线程数
    private static final int MAXIMUM_POOL_SIZE = CORE_POOL_SIZE;

    // 非核心线程存活时间100毫秒
    private static final long KEEP_ALIVE_TIME = 100;

    // 时间单位设置为毫秒
    private static final TimeUnit UNIT = TimeUnit.MILLISECONDS;

    // 初始化数组结构阻塞队列的大小为 5
    private static final BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(5);

    // 自定义个线程创建工厂
    private static final ThreadFactory THREAD_FACTORY = new MyThreadFactory();

    // 抛出 RejectedExecutionException来拒绝新任务的处理。
    private static final RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.AbortPolicy();

    public static ThreadPoolExecutor getPool() {
        if (singleTon == null) {
            synchronized (ThreadPoolManager.class) {
                if (singleTon == null) {
                    /**
                     * ThreadPoolExecutor 3 个最重要的参数：
                     *
                     * corePoolSize : 核心线程数线程数定义了最小可以同时运行的线程数量。
                     * maximumPoolSize : 当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
                     * workQueue: 当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。
                     * ThreadPoolExecutor其他常见参数:
                     *
                     * keepAliveTime:当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
                     * unit : keepAliveTime 参数的时间单位。
                     * threadFactory :executor 创建新线程的时候会用到。
                     * handler :饱和策略。关于饱和策略下面单独介绍一下。
                     */
                    singleTon = new ThreadPoolExecutor(CORE_POOL_SIZE,
                            MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, UNIT,
                            WORK_QUEUE, THREAD_FACTORY, HANDLER);
                }
            }
        }
        return singleTon;
    }

    /**
     * 自定义线程生成工厂，该类为
     * 每个线程增加一个计数标识
     */
    private static class MyThreadFactory implements ThreadFactory {
        // 从1开始增长打印线程名
        AtomicInteger atomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "--->线程"+String.valueOf(atomicInteger.getAndIncrement()));
            return thread;
        }
    }

}


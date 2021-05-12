package com.upup.fng.engine.thread;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/3/4 上午9:37
 */
public abstract class ItpRunnableM implements Runnable{
    
    @Override
    public void run() {
        while(true){
            //任务执行
            try {
                this.execute();
            }
            catch (Exception e) {
                System.out.println("████MainTask████"+Thread.currentThread().getName()+" ██=====>执行失败!");
            }
            //任务休眠
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println("████MainTask████"+Thread.currentThread().getName()+" ██=====>休眠失败!");
            }
        }
    }

    public abstract void execute();
}

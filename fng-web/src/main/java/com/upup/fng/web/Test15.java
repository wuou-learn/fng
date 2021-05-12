package com.upup.fng.web;

/**
 * @author 王建起
 * @create 2021-03-02 14:47
 */
public class Test15 {
    static Beer beer = new Beer();
    static Story story = new Story();

    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (beer){
                //log.info("我有酒，给我故事");
                System.out.println("我有酒，给我故事");
                try {
                    beer.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (story){
                    //log.info("小王开始喝酒讲故事");
                    System.out.println("小王开始喝酒讲故事");
                    story.notify();
                }
            }
        },"小王").start();

        new Thread(() ->{
            synchronized (story){
                //log.info("我有故事，给我酒");
                System.out.println("我有故事，给我酒");
                try {
                    story.wait();
                    story.say();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (beer){
                    //log.info("老王开始喝酒讲故事");
                    System.out.println("老王开始喝酒讲故事");

                }
            }
        },"老王").start();
    }

}
class Beer {
}

class Story{
    public void say(){
        System.out.println("老王真帅");
    }

}



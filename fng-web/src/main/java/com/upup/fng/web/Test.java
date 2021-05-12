package com.upup.fng.web;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/3/3 下午4:48
 */
public class Test {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        String o = threadLocal.get();
        if(o == null){
            o = Thread.currentThread().getName();
        }
        System.out.println(o);
    }
}

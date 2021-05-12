package com.upup.fng.test;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/8/21 上午11:25
 */
public class Test001 {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        TestController testController = new TestController();
        Class<? extends TestController> testControllerClass = testController.getClass();
        Field[] fields = testControllerClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            Insert annotation = field.getAnnotation(Insert.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object o = type.newInstance();
                field.set(testController,o);
            }
        }
        System.out.println(testController.getTestService());
    }
}

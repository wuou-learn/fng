package com.upup.fng.test;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/8/21 上午11:23
 */
public class TestController {
    
    @Insert
    private TestService testService;

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}

package com.upup.fng.engine.log;

/**
 * 日志枚举类
 */
public enum Log {
    /** 操作日志 */
    OPERATE("OPERATE");

    private String logName;

    Log(String logName) {
        this.logName = logName;
    }

    /**
     * 获取 logName
     * @return the logName
     */
    public String getLogName() {
        return logName;
    }
}

package com.upup.fng.engine.log;

/**
 * 日志等级枚举
 */
public enum LogLevel {

	/**
	 * 错误级别
	 */
	ERROR("ERROR"),
	
	/**
	 * 警告级别
	 */
	WARN("WARN"),
	
	/**
	 * 信息级别
	 */
	INFO("INFO"),
	
	/**
	 * 调试级别
	 */
	DEBUG("DEBUG");
	
	private String level;
	
	/**
	 * 私有化构造方法
	 */
	private LogLevel(String level){
		this.level = level;
	}

	/**
	 * 获取 level
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	
}

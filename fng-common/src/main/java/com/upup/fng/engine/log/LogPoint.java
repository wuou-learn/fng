package com.upup.fng.engine.log;

/**
 * 日志记录点枚举
 */
public enum LogPoint {
	
	/**
	 * 在方法运行前记录日志
	 */
	BEFORE("before"),
	
	/**
	 * 在方法运行后记录日志
	 */
	AFTER("after"),

	/**
	 * 在抛出异常时记录日志
	 */
	THROW("throw");

	private String name;

	/**
	 * 私有化构造方法
	 */
	private LogPoint(String name){
		this.name = name;
	}

	/**
	 * 获取 name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}

package com.neeson.code.mbean.simple;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 21:27
 * Description: 简单 mbean
 */
public interface SimpleDataMBean {

	/**
	 * 属性
	 * @param data
	 */
	void setData(String data);

	/**
	 * 属性
	 * @return
	 */
	String getData();

	/**
	 * 操作
	 * @return
	 */
	String displayData();

}

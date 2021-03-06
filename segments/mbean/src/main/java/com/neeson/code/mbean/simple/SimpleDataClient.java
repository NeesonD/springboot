package com.neeson.code.mbean.simple;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 21:42
 * Description: 
 */
public class SimpleDataClient {

	public static void main(String[] args)
			throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException,
			MBeanRegistrationException, InterruptedException {
		// MBean 服务器 - Agent Level
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

		// 注册对象
		SimpleData simpleData = new SimpleData();

		// 注册名称
		ObjectName objectName = createObjectName(simpleData);

		// 注册 MBean - SimpleDataMBean
		mBeanServer.registerMBean(simpleData,objectName);

		Thread.sleep(Long.MAX_VALUE);

	}


	private static ObjectName createObjectName(Object mbean) throws MalformedObjectNameException {
		Class<?> mbeanClass = mbean.getClass();
		String packageName = mbeanClass.getPackage().getName();
		String className = mbeanClass.getSimpleName();

		return new ObjectName(packageName + ":type=" + className);
	}

}

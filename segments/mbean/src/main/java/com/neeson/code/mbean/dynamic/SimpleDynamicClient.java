package com.neeson.code.mbean.dynamic;

import com.neeson.code.mbean.simple.SimpleData;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 21:50
 * Description: 
 */
public class SimpleDynamicClient {

	public static void main(String[] args)
			throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException,
			MBeanRegistrationException, InterruptedException {
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		// 注册对象
		SimpleDynamicMbean simpleDynamicMbean = new SimpleDynamicMbean();

		// 注册名称
		ObjectName objectName = createObjectName(simpleDynamicMbean);

		// 注册 MBean - simpleDynamicMbean
		mBeanServer.registerMBean(simpleDynamicMbean,objectName);

		Thread.sleep(Long.MAX_VALUE);

	}


	private static ObjectName createObjectName(Object mbean) throws MalformedObjectNameException {
		Class<?> mbeanClass = mbean.getClass();
		String packageName = mbeanClass.getPackage().getName();
		String className = mbeanClass.getSimpleName();

		return new ObjectName(packageName + ":type=" + className);
	}

}

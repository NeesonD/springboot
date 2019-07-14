package com.neeson.code.mbean.dynamic;

import javax.management.*;

import static javax.management.MBeanOperationInfo.ACTION;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 21:47
 * Description: 
 */
public class SimpleDynamicMbean implements DynamicMBean {

	private String value;


	@Override
	public Object getAttribute(String attribute)
			throws AttributeNotFoundException, MBeanException, ReflectionException {
		return value;
	}

	@Override
	public void setAttribute(Attribute attribute) {
		String attributeName = attribute.getName();
		if ("value".equals(attributeName)) {
			this.value = (String) attribute.getValue();
		}
	}

	@Override
	public AttributeList getAttributes(String[] attributes) {
		return null;
	}

	@Override
	public AttributeList setAttributes(AttributeList attributes) {
		return null;
	}

	@Override
	public Object invoke(String actionName, Object[] params, String[] signature) {
		if ("displayValue".equals(actionName)) {
			return value;
		}
		return null;
	}

	@Override
	public MBeanInfo getMBeanInfo() {
		return new MBeanInfo(
				this.getClass().getName(),
				"简单的自定义DynamicMBean",
				of(new MBeanAttributeInfo("value", String.class.getName(), "动态属性value", true, true, false)),
				of(new MBeanConstructorInfo(this.getClass().getSimpleName(), "默认构造器", new MBeanParameterInfo[0])),
				of(new MBeanOperationInfo("displayValue", "自定义 displayValue 方法", new MBeanParameterInfo[0], String.class.getName(), ACTION)),
				new MBeanNotificationInfo[0]);
	}

	private static <T> T[] of(T... array) {
		return array;
	}

}

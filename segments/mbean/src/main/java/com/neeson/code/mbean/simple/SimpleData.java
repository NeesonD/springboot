package com.neeson.code.mbean.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.management.*;
import java.util.concurrent.atomic.AtomicLong;

import static javax.management.AttributeChangeNotification.ATTRIBUTE_CHANGE;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 21:28
 * Description: 
 */
public class SimpleData extends NotificationBroadcasterSupport implements SimpleDataMBean, NotificationListener,
		NotificationFilter {

	private String data;

	private static final AtomicLong sequenceNumber = new AtomicLong();

	public SimpleData() {
		this.addNotificationListener(this,this,null);
	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public String displayData() {
		return data;
	}

	@Override
	public void setData(String data) {
		String oldData = this.data;
		this.data = data;
		Notification notification = new AttributeChangeNotification(this, sequenceNumber.incrementAndGet(),
				System.currentTimeMillis(), "Data has been changed from " + oldData + " to " + data, "data",
				String.class.getName(), oldData, data);
		sendNotification(notification);
	}



	@Override
	public boolean isNotificationEnabled(Notification notification) {

		if (AttributeChangeNotification.class.isAssignableFrom(notification.getClass())) {
			AttributeChangeNotification attributeChangeNotification = AttributeChangeNotification.class.cast(notification);
			if ("data".equals(attributeChangeNotification.getAttributeName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void handleNotification(Notification notification, Object handback) {
		AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;
		String oldValue = (String) attributeChangeNotification.getOldValue();
		String newValue = (String) attributeChangeNotification.getNewValue();
		System.out.printf("The notification of data's attribute  - old data : %s , new data : %s \n", oldValue, newValue);
	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		return new MBeanNotificationInfo[]{
				new MBeanNotificationInfo(new String[]{ATTRIBUTE_CHANGE},"Data Change Notification",
				"数据改变通知")
		};
	}
}

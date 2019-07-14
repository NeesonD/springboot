package com.neeson.code.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 21:52
 * Description: 
 */
@ManagedResource(
		objectName = "com.neeson.code.jmx.SimpleBean:type=SimpleBean",
		description = "被 spring 管理的 mbean"
)
@Component
public class SimpleBean {

	private Long id;

	private String name;

	private Integer value;

	@ManagedAttribute(description = "ID 属性")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManagedAttribute(description = "Name 属性")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManagedAttribute(description = "Value 属性")
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@ManagedOperation(description = "display 操作")
	public String display() {
		return this.toString();
	}


}

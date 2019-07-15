package com.neeson.code.domain;

import com.neeson.code.validation.PersonNamePrefix;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author : neeson
 * Date: 2019/7/15
 * Time: 22:03
 * Description: 
 */
@Data
public class Person {


	@NotNull
	@PersonNamePrefix(prefix = "segmentfault-")
	private String name;

	@Min(value = 0)
	@Max(value = 200
			, message = "{person.age.max.message}"
	)
	private int age;

}

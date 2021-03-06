package com.neeson.code.controller;

import com.neeson.code.jmx.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 21:54
 * Description: 
 */
@RestController
public class JMXController {


	@Autowired
	private SimpleBean simpleBean;


	@GetMapping("/jmx/simple-bean")
	public SimpleBean simpleBean(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer value) {

		if (id != null) {
			simpleBean.setId(id);
		}

		if (name != null) {
			simpleBean.setName(name);
		}

		if (value != null) {
			simpleBean.setValue(value);
		}

		return simpleBean;

	}


}

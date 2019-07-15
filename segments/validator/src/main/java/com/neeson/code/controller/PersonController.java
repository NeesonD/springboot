package com.neeson.code.controller;

import com.neeson.code.domain.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : neeson
 * Date: 2019/7/15
 * Time: 22:12
 * Description: 
 */
@RestController
public class PersonController {

	@PostMapping("/person/save")
	public Person save(@Valid @RequestBody Person person) {

		return person;

	}

}

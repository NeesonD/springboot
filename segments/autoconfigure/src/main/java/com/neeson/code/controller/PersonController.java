package com.neeson.code.controller;

import com.neeson.code.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : neeson
 * Date: 2019/7/15
 * Time: 21:48
 * Description: 
 */
@RestController
public class PersonController {

	private Person person;

	public PersonController(Person person) {
		this.person = person;
	}


	@GetMapping("/person")
	public Person person() {
		return person;
	}

}

package com.neeson.code.configuration;

import com.neeson.code.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 22:43
 * Description: 
 */
@Configuration
public class PersonConfiguration {

	@Bean
	@Profile("prod")
	public Person zhangxueyou() {
		Person person = new Person();
		return person;
	}

	@Bean
	@Profile("test")
	public Person zhangkai() {
		Person person = new Person();
		return person;
	}

}

package com.neeson.code.autoconfigure;

import com.neeson.code.domain.Person;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author : neeson
 * Date: 2019/7/15
 * Time: 21:47
 * Description: 
 */
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "person",name = "enable",havingValue = "true")
@AutoConfigureAfter(EmbeddedWebServerFactoryCustomizerAutoConfiguration.class)
public class PersonAutoConfiguration {

	@ConfigurationProperties(prefix = "person")
	@Bean
	public Person person() {
		return new Person();
	}

}

package com.neeson.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 22:03
 * Description: 
 */
@Slf4j
@ImportResource(locations = {
		"META-INF/spring/context.xml",
		"META-INF/spring/context-test.xml",
		"META-INF/spring/context-prod.xml"
})
@SpringBootApplication
public class ConfigSpringApplication implements EnvironmentAware {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSpringApplication.class, args);
	}

	@Override
	public void setEnvironment(Environment environment) {
		log.error("当前激活的Profiles : " + Arrays.asList(environment.getActiveProfiles()));

		if (environment instanceof ConfigurableEnvironment) {
			ConfigurableEnvironment env = (ConfigurableEnvironment) environment;

			MutablePropertySources mutablePropertySources = env.getPropertySources();

			Map<String, Object> source = new HashMap<>();

			source.put("server.port", 1234);

			PropertySource propertySource = new MapPropertySource("java-code", source);

			mutablePropertySources.addFirst(propertySource);
		}
	}
}

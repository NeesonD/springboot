package com.neeson.code.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 22:24
 * Description: 
 */
@Data
@Component
@ConfigurationProperties(prefix = "book")
public class Book {

	private String isbn;

	private String name;

}

package com.neeson.code.controller;

import com.neeson.code.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 22:48
 * Description: 
 */
@RestController
public class BookController {

	@Autowired
	private Book book;

	@GetMapping("/book")
	public Book book() {
		return book;
	}

}

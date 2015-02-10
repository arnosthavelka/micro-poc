package com.asseco.aha.poc.micro.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	String hello() {
		return String.format("Hello!");
	}
}

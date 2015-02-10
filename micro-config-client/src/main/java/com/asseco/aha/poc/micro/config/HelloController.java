package com.asseco.aha.poc.micro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private ConfigurationDTO cfg;

	@RequestMapping("/hello")
	String hello() {
		return String.format("Hello %s!", cfg.getName());
	}
}

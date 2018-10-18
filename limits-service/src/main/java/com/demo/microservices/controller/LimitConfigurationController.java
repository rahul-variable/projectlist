package com.demo.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

	@Autowired
	Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retieveLimitConfig() {
		
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}
}

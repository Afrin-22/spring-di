package com.springframework.sdi.controllers;

import com.springframework.sdi.services.GreetingService;

public class PropertyInjectedController {

	GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}

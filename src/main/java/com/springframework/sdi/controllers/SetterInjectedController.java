package com.springframework.sdi.controllers;

import com.springframework.sdi.services.GreetingService;

public class SetterInjectedController {

	private GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
}

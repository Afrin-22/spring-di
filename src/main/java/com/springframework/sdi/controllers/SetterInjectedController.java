package com.springframework.sdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.sdi.services.GreetingService;

@Controller
public class SetterInjectedController {

	@Qualifier("setterGreetingService")
	@Autowired
	private GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
}

package com.springframework.sdi.services;

public class SetterGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		
		return "Hello world---setter!";
	}

}

package com.springframework.sdi.services;

public class PropertyGreetingService implements GreetingService{

	@Override
	public String sayGreeting() {
		
		return "Hello world---property!";
	}
}

package com.springframework.sdi.services;

public class ConstructorGreetingService implements GreetingService{

	@Override
	public String sayGreeting() {
		
		return "Hello world---constructor!";
	}

}

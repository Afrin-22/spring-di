package com.springframework.sdi.services;

public class GreetingServiceImpl implements GreetingService{

	@Override
	public String sayGreeting() {
		
		return "Hello world!";
	}

}

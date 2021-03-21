package com.springframework.sdi.repositories;

public class EnglishGreetingReporsitoryImpl implements EnglishGreetingRepository{

	public String getGreeting() {
		return "Hello world---English repo!";
	}
}

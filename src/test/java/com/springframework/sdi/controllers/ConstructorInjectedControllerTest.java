package com.springframework.sdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.sdi.services.GreetingServiceImpl;

public class ConstructorInjectedControllerTest {

	ConstructorInjectedController controller;
	
	@BeforeEach
	void setup() {
		controller = new ConstructorInjectedController(new GreetingServiceImpl());	
	}
	
	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}
}

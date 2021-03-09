package com.springframework.sdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.sdi.services.GreetingServiceImpl;

public class PropertyInjectedControllerTest {

	 PropertyInjectedController controller;
	
	//setting up the test conditions in setup()
	@BeforeEach
	void setup() {
		controller = new PropertyInjectedController();
		controller.greetingService = new GreetingServiceImpl();
	}
	
	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}
}

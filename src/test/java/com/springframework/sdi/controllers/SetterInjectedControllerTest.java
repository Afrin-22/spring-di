package com.springframework.sdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.sdi.services.GreetingServiceImpl;

public class SetterInjectedControllerTest {

	SetterInjectedController controller;
	
	@BeforeEach
	void setup() {
		controller = new SetterInjectedController();
		controller.setGreetingService(new GreetingServiceImpl());
	}	
	@Test
	void sayGreeting() {
		System.out.println(controller.getGreeting());
	}
	
}

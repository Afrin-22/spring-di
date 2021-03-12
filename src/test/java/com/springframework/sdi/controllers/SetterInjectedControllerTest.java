package com.springframework.sdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.sdi.services.ConstructorGreetingService;

public class SetterInjectedControllerTest {

	SetterInjectedController controller;
	
	@BeforeEach
	void setup() {
		controller = new SetterInjectedController();
		controller.setGreetingService(new ConstructorGreetingService());
	}	
	@Test
	void sayGreeting() {
		System.out.println(controller.getGreeting());
	}
	
}

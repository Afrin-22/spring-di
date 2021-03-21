package com.springframework.sdi.services;

public class I18nSpanishGreetingService implements GreetingService{

	@Override
	public String sayGreeting() {
		
		return "Hola Mundo---Espanol!";
	}

}

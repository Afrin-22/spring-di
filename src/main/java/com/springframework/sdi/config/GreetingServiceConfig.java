package com.springframework.sdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.sdi.repositories.EnglishGreetingReporsitoryImpl;
import com.springframework.sdi.repositories.EnglishGreetingRepository;
import com.springframework.sdi.services.ConstructorGreetingService;
import com.springframework.sdi.services.I18nEnglishGreetingService;
import com.springframework.sdi.services.I18nSpanishGreetingService;
import com.springframework.sdi.services.PrimaryGreetingService;
import com.springframework.sdi.services.PropertyGreetingService;
import com.springframework.sdi.services.SetterGreetingService;

@Configuration
public class GreetingServiceConfig {

	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingReporsitoryImpl();
	}
	
	@Bean
	@Profile({"EN", "default"})
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}
	
	@Bean("i18nService")
	@Profile("ES")
	I18nSpanishGreetingService i18nSpanishService() {
		return new I18nSpanishGreetingService();
	}
	
	@Bean
	@Primary
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}
	
	@Bean
	ConstructorGreetingService constructorGreetingService() {
		 return new ConstructorGreetingService();
	}

	@Bean
	PropertyGreetingService propertyGreetingService() {
		return new PropertyGreetingService();
	}
	
	@Bean
	SetterGreetingService setterGreetingService() {
		return new SetterGreetingService();
	}
}

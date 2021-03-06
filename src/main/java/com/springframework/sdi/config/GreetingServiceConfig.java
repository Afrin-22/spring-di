package com.springframework.sdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import com.springframework.sdi.datasource.FakeDataSource;
import com.springframework.sdi.repositories.EnglishGreetingReporsitoryImpl;
import com.springframework.sdi.repositories.EnglishGreetingRepository;
import com.springframework.sdi.services.I18nEnglishGreetingService;
import com.springframework.sdi.services.I18nSpanishGreetingService;
import com.springframework.sdi.services.PrimaryGreetingService;
import com.springframework.sdi.services.PropertyGreetingService;
import com.springframework.sdi.services.SetterGreetingService;

@EnableConfigurationProperties(SdiConstructorConfig.class)
@ConfigurationProperties
@ImportResource("classpath:sdi-config.xml")
@Configuration
public class GreetingServiceConfig {

	//injecting values directly from properties
/*	@Bean
	FakeDataSource fakeDataSource( @Value("${datasource.username}") String username, @Value("${datasource.password}") String password,
			@Value("${datasource.jdbcurl}") String jdbcurl) {
		FakeDataSource fds = new FakeDataSource();
		fds.setUsername(username);
		fds.setPassword(password);
		fds.setJdbcurl(jdbcurl);
		return fds;
	}
*/
	//injecting a class which consumes data from properties
/*	@Bean
	FakeDataSource fakeDataSource(SdiConfiguration sdiConfiguration) {
		FakeDataSource fds = new FakeDataSource();
		fds.setUsername(sdiConfiguration.getUsername());
		fds.setPassword(sdiConfiguration.getPassword());
		fds.setJdbcurl(sdiConfiguration.getJdbcurl());
		return fds;
	}
*/
	
	//Constructor Binding
	@Bean
	FakeDataSource fakeDataSource(SdiConstructorConfig sdiConstructorConfig) {
		FakeDataSource fds = new FakeDataSource();
		fds.setUsername(sdiConstructorConfig.getUsername());
		fds.setPassword(sdiConstructorConfig.getPassword());
		fds.setJdbcurl(sdiConstructorConfig.getJdbcurl());
		return fds;
	}
	
	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}
	
	@Bean
	@Profile({"dog", "default"})
	PetService dogPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("dog");
	}
	
	@Bean
	@Profile("cat")
	PetService catPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("cat");
	}
	
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
	
	/*
	 * @Bean ConstructorGreetingService constructorGreetingService() { return new
	 * ConstructorGreetingService(); }
	 */

	@Bean
	PropertyGreetingService propertyGreetingService() {
		return new PropertyGreetingService();
	}
	
	@Bean
	SetterGreetingService setterGreetingService() {
		return new SetterGreetingService();
	}
}

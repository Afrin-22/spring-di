package com.springframework.sdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springframework.sdi.controllers.ConstructorInjectedController;
import com.springframework.sdi.controllers.MyController;
import com.springframework.sdi.controllers.PropertyInjectedController;
import com.springframework.sdi.controllers.SetterInjectedController;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);
		
		MyController myController = (MyController) ctx.getBean("myController");
		
		String greeting = myController.sayHello();
		
		System.out.println(greeting);
		
		System.out.println("---------property-----");
		PropertyInjectedController pic = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(pic.getGreeting());
		
		System.out.println("---------setter-----");
		SetterInjectedController sic = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(pic.getGreeting());
		
		System.out.println("---------constructor-----");
		ConstructorInjectedController cic = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(pic.getGreeting());
	}

}

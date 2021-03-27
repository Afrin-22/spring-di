package com.springframework.sdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springframework.sdi.config.SdiConfiguration;
import com.springframework.sdi.config.SdiConstructorConfig;
import com.springframework.sdi.controllers.ConstructorInjectedController;
import com.springframework.sdi.controllers.I18nController;
import com.springframework.sdi.controllers.MyController;
import com.springframework.sdi.controllers.PetController;
import com.springframework.sdi.controllers.PropertyInjectedController;
import com.springframework.sdi.controllers.SetterInjectedController;
import com.springframework.sdi.datasource.FakeDataSource;
import com.springframework.sdi.services.PrototypeBean;
import com.springframework.sdi.services.SingletonBean;

//removed @ComponantScan as we introduced factory pattern
//@ComponentScan(basePackages = {"com.springframework.pets","com.springframework.sdi"})
@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);
		
		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());
		
		System.out.println("---------Profiles active-----");

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
				
		System.out.println(i18nController.getGreeting());
		
		System.out.println("---------primary bean-----");

		MyController myController = (MyController) ctx.getBean("myController");
				
		System.out.println(myController.sayHello());
		
		System.out.println("---------property-----");
		PropertyInjectedController pic = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(pic.getGreeting());
		
		System.out.println("---------setter-----");
		SetterInjectedController sic = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(sic.getGreeting());
		
		System.out.println("---------constructor-----");
		ConstructorInjectedController cic = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(cic.getGreeting());
		
		System.out.println("---------Bean scopes-----");
		SingletonBean sb1 = ctx.getBean(SingletonBean.class);
		System.out.println(sb1.getScopeType());
		
		SingletonBean sb2 = ctx.getBean(SingletonBean.class);
		System.out.println(sb2.getScopeType());
		
		PrototypeBean pb1 = ctx.getBean(PrototypeBean.class);
		System.out.println(pb1.getScopeType());
		
		PrototypeBean pb2 = ctx.getBean(PrototypeBean.class);
		System.out.println(pb2.getScopeType());
		
		System.out.println("-------Fake datasource------");
		FakeDataSource fds = ctx.getBean(FakeDataSource.class);
		System.out.println("username:"+fds.getUsername());
		System.out.println("password:"+fds.getPassword());
		System.out.println("jdbc url:"+fds.getJdbcurl());
		
		System.out.println("------Config Props Bean-----");
		SdiConfiguration sdiConfig = ctx.getBean(SdiConfiguration.class);
		System.out.println("username:"+sdiConfig.getUsername());
		System.out.println("password:"+sdiConfig.getPassword());
		System.out.println("jdbc url:"+sdiConfig.getJdbcurl());
		
		System.out.println("-------Constructor Binding-----");
		SdiConstructorConfig sdiConstructorConfig = ctx.getBean(SdiConstructorConfig.class);
		System.out.println("username:"+sdiConstructorConfig.getUsername());
		System.out.println("password:"+sdiConstructorConfig.getPassword());
		System.out.println("jdbc url:"+sdiConstructorConfig.getJdbcurl());
	}

}

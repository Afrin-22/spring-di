package com.springframework.sdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

	public PrototypeBean() {
		System.out.println("creating prototype bean!!");
	}

	public String getScopeType() {
		return "PROTOTYPE";
	}
}

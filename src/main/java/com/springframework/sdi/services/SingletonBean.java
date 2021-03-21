package com.springframework.sdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

	public SingletonBean() {
		System.out.println("creating singleton bean..");
	}

	public String getScopeType() {
		return "SINGLETON";
	} 
	
}

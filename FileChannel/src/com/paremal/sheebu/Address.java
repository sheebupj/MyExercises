package com.paremal.sheebu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Address {
	@Autowired
	@Value("paremal")
	String housename;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String housename) {
		super();
		this.housename = housename;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}
	
	

}

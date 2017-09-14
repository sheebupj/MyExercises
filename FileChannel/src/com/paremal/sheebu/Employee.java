package com.paremal.sheebu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Employee {
	String name ;
	Address address;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public Employee( Address address) {
		super();
		
		this.address = address;
	
	}
	public String getName() {
		return name;
	}
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}

package com.impelsys.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

	private List<Customer> customers = new ArrayList<Customer>();

	// Dummy database. Initialize with some dummy values.
	public CustomerDAO() {
		super();
		// TODO Auto-generated constructor stub
		customers.add(new Customer(1, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
		customers.add(new Customer(2, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
		customers.add(new Customer(3, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));

	}

	/**
	 * Returns list of customers from dummy database.
	 * 
	 * @return list of customers
	 */
	public List list() {
		return customers;

	}
	
	public Customer get(Long id) {

		for (Customer c : customers) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
}

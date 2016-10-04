package com.edn.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.edn.model.Customer;

@Component
public class CustomerRepository {
	
	private static List<Customer> customers;
	
	public CustomerRepository() {
		customers = new ArrayList<>();
		customers.add( new Customer(201, "Marjorie", "marjor@gmail.com", "8888-8888") );
		customers.add( new Customer(202, "Nadine", "nadine@gmail.com", "9999-9999") );
		customers.add( new Customer(203, "Giselle", "giselle@yahoo.com", "7777-7777") );
		customers.add( new Customer(204, "Edney", "edney@hotmail.com", "6666-6666") );
	}
	
	
	public List<Customer> list() {
		return customers;
	}
	
	public Customer getCustomer(long id) {
		for(Customer c : customers) {
			if(c.getId().equals(id)) return c;
		}
		return null;
	}
	
	public Customer create(Customer customer) {
		customer.setId(System.currentTimeMillis());
		customers.add(customer);
		return customer;
	}
	
	public Long delete(Long id) {
		for(Customer c : customers) {
			if(c.getId().equals(id)) {
				customers.remove(c);
				return id;
			}
		}
		return null;		
	}
	
	public Customer update(Long id, Customer customer) {
		for(Customer c : customers) {
			if(c.getId().equals(id)) {
				customer.setId(c.getId());
				customers.remove(c);
				customers.add(customer);
				return customer;
			}
			
		}
		return null;
	}
	
}

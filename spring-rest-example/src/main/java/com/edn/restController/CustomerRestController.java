package com.edn.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.edn.model.Customer;
import com.edn.repository.CustomerRepository;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepository repository;
	
	// http://viralpatel.net/blogs/spring-4-mvc-rest-example-json/
	// http://viralpatel.net/blogs/embed-tomcat-maven-project-run-tomcat-maven/
	
}

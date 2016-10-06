package com.edn.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edn.model.Customer;
import com.edn.repository.CustomerRepository;

@RestController
@SuppressWarnings({"rawtypes", "unchecked"})
public class CustomerRestController {

	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/customers")
	public List<Customer> list() {
		return repository.list();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") long id) {
		
		Customer c = repository.getCustomer(id);
		if(c == null) {
			return new ResponseEntity("No customer found for id: " + id, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(c, HttpStatus.OK);
	}

	@PostMapping("/customers")
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		
		repository.create(customer);
		
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == repository.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		customer = repository.update(id, customer);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
}
package com.cognixia.jump.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerService custService;
	
	
	@GetMapping("/customer/{customerId}")
	public Customer findByCustomerId(Integer customerId) {
		return null;
	}
	
	@PostMapping("/customer")
	public Customer save(Customer cust) {
		return null;
	}
	
}

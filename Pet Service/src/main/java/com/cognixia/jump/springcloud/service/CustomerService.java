package com.cognixia.jump.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Customer;

@Service
@FeignClient("customer-service")
public interface CustomerService {
	
	@GetMapping("/customer/{customerId}")
	public Customer findByCustomerId(Integer customerId);
	
	@PostMapping("/customer")
	public Customer save(Customer cust);

}

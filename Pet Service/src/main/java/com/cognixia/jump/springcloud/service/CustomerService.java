package com.cognixia.jump.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Customer;

@Service
@FeignClient("account-service")
public interface CustomerService {
	
	@GetMapping("/account/{accountId}")
	public Customer findByCustomerId(Integer customerId);
	
	@PostMapping("/account")
	public Customer save(Customer cust);

}

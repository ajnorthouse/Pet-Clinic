package com.cognixia.jump.springcloud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.model.Account;
import com.cognixia.jump.springcloud.model.Customer;
import com.cognixia.jump.springcloud.repository.CustomerRespository;
import com.cognixia.jump.springcloud.service.AccountService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRespository repo;
	
	@Autowired
	AccountService acctService;
	
	@GetMapping("/helloCustomer")
	public String helloCustomer() {
		return "Hello from Customer Service - Controller!!";
	}
	
	@GetMapping("/customer/{id}")
	public Customer findByCustomerId(@PathVariable Integer id) {
		return repo.findByCustomerId(id);
	}
	
	@PostMapping("/addCustomer")
	public Optional<Customer> saveCustomer(@RequestBody Customer c) {
		Optional<Customer> custAdd = Optional.of(c);
		if(custAdd.isPresent()) {
			repo.save(custAdd.get());
		}
		return custAdd;
	}
	
	@PostMapping("/account")
	public Account saveAccount(@RequestBody Account acct) {
		return acctService.save(acct);
	}
//	
//	@PostMapping("/addAccount")
//	public Optional<Account> saveAccount(@RequestBody Account a) {
//		Optional<Account> acctAdd = Optional.of(a);
//		if(acctAdd.isPresent()) {
//			repo.save(acctAdd.get());
//		}
//		return acctAdd;
	}

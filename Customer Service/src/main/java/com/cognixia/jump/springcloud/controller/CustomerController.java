package com.cognixia.jump.springcloud.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.model.Pet;
import com.cognixia.jump.springcloud.model.Customer;
import com.cognixia.jump.springcloud.repository.CustomerRespository;
import com.cognixia.jump.springcloud.service.AccountService;

@RestController
public class CustomerController {
	
	//repos and services
	@Autowired
	CustomerRespository repo;
	@Autowired
	AccountService acctService;
	
	//CREATE
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer c) {
		//temp object
		Customer created;
		
		
		//checks for pet list to decide on which constructor to use
		if (c.getPets() != null) {
			created = new Customer(c.getId(), c.getName(), c.getPhoneNumber(),
									c.getEmailAddress(), c.getCity(), c.getPets());
		} else {
			created = new Customer(c.getId(), c.getName(), c.getPhoneNumber(),
									c.getEmailAddress(), c.getCity());
		}
		
		//adds customer and returns result
		repo.save(created);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	@PostMapping("/customer/{id}/pet")
	public Pet saveAccount(@PathVariable Integer id, @Valid @RequestBody Pet pet) {
		//TODO: implement adding a SINGLE pet
		return acctService.save(pet);
	}
	//TODO: implement adding a list of pets
	
	
	
	//READ
	//TODO: implement finding all customers 
	//TODO: implement finding customer by Id
	//TODO: implement finding customer by name
	//TODO: implement finding customer by phone number
	//TODO: implement finding customer by email address
	//TODO: implement finding customer by city
	//TODO: implement return all pets by customer id
	
	
	
	//UPDATE
	//TODO: implement update customer name
	//TODO: implement update customer phone number
	//TODO: implement update customer email address
	//TODO: implement update customer city
	//TODO: pets??? 
	@PutMapping("/update/customer")
	public @ResponseBody String updateCustomer(@RequestBody Customer cust) {
		
		Optional<Customer> found = repo.findById(cust.getId());
		
		if(found.isPresent()) {
			repo.save(cust);
			return "Saved: " + cust.toString();
		}
		else {
			return "Could not update customer with id = " + cust.getId();
		}
		
	}
	
	//DELETE
	@DeleteMapping("/delete/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
		
		Optional<Customer> found = repo.findById((int) id);
		
		if(found.isPresent()) {
			repo.deleteById((int) id);
			return ResponseEntity.status(200).body("Deleted customer with id = " + id);
		}
		else {
			return ResponseEntity.status(400).body("Customer with id = " + id + " not found.");
		}
		
	}
}

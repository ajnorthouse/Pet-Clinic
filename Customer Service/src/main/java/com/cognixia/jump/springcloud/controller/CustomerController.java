package com.cognixia.jump.springcloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}
	//TODO: implement finding all customers 
	//TODO: implement finding customer by Id
	//TODO: implement finding customer by name
	//TODO: implement finding customer by phone number
	//TODO: implement finding customer by email address
	//TODO: implement finding customer by city
	//TODO: implement return all pets by customer id
	
	
	
	//UPDATE Customer
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
	
	//PATCH Customer details
	@PatchMapping("customer")
	public @ResponseBody String[] updateCustomer(@RequestBody Map<String, String> custuUpdate) {
		// collect id from map and attempt to get matching Customer
		long id = Long.parseLong(custuUpdate.getOrDefault("id", "-1"));
		Optional<Customer> found = repo.findById((int) id);
		
		// update logic
		if (id != -1L && found.isPresent()) {
			//collects the update values from the map
			Customer toUpdate = found.get();
			String newName = custuUpdate.get("name");
			String newPhoneNumber = custuUpdate.get("phoneNumber");
			String newEmailAddress = custuUpdate.get("emailAddress");
			String newCity = custuUpdate.get("city");
			
			List<String> response = new ArrayList<String>();
			
			//updates name
			if (newName != null) {
				response.add(updateCustomerName(toUpdate, newName));
			}
			//updates phone number
			if (newPhoneNumber != null) {
				response.add(updateCustomerPhoneNumber(toUpdate, newPhoneNumber));
			}
			//updates email address
			if (newEmailAddress != null) {
				response.add(updateCustomerEmailAddress(toUpdate, newEmailAddress));
			}
			//updates city
			if (newCity != null) {
				response.add(updateCustomerCity(toUpdate, newCity));
			}
			
			//returns updated strings
			repo.save(toUpdate);
			return response.toArray(String[]::new);
		} 
		// failed to find Customer logic
		else {
			return new String[]{"Could not update city of Customer with id: " + id};
		}
	}
	String updateCustomerName(Customer Customer, String newName) {
		String oldName = Customer.getName();
		Customer.setName(newName);
		return "Previous name: " + oldName + ", New: " + newName;
	}
	String updateCustomerPhoneNumber(Customer Customer, String newPhoneNumber) {
		String oldPhoneNumber = Customer.getPhoneNumber();
		Customer.setPhoneNumber(newPhoneNumber);
		return "Old phone number: " + oldPhoneNumber + ", New: " + newPhoneNumber;
	}
	String updateCustomerEmailAddress(Customer Customer, String newEmailAddress) {
		String oldEmail = Customer.getEmailAddress();
		Customer.setEmailAddress(newEmailAddress);
		return "Old Email: " + oldEmail + ", New: " + newEmailAddress;
	}
	String updateCustomerCity(Customer Customer, String newCity) {
		String oldCity = Customer.getCity();
		Customer.setCity(newCity);
		return "Previous City " + oldCity + ", New: " + newCity;
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

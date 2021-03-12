package com.cognixia.jump.springcloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.springcloud.model.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer>{
	
	Customer findByCustomerId(Integer customerId);
	
	List<Customer> findByName(String name);
	
	List<Customer> findByEmailAddress(String emailAddress);
	
}

package com.cognixia.jump.springcloud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.springcloud.model.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer>{
	
	List<Customer> findAll();
	Optional<Customer> findByCustomerId(Integer customerId);
	Optional<Customer> findByName(String name);
	Optional<Customer> findByEmailAddress(String email);
	Optional<Customer> findByPhoneNumber(String phone);
	Optional<Customer> findByCity(String city);
	
}

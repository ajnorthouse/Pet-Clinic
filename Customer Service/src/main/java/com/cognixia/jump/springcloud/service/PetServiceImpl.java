package com.cognixia.jump.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Pet;

@Component
public class PetServiceImpl implements PetService {
	
	@Autowired
	PetService acctService;
	
	
	@GetMapping("/pet/{accountId}")
	public Pet findByPetId(Integer petId) {
		return null;
	}
	
	@PostMapping("/pet")
	public Pet save(Pet pet) {
		return null;
	}

}

package com.cognixia.jump.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Pet;

@Service
@FeignClient("pet-service")
public interface PetService {
	
	@GetMapping("/pet/{petId}")
	public Pet findByPetId(Integer petId);
	
	@PostMapping("/pet")
	public Pet save(Pet acct);

}

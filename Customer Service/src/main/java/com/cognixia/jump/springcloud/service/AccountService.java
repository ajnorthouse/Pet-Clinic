package com.cognixia.jump.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Pet;

@Service
@FeignClient("account-service")
public interface AccountService {
	
	@GetMapping("/account/{accountId}")
	public Pet findByAccountId(Integer accountId);
	
	@PostMapping("/account")
	public Pet save(Pet acct);

}

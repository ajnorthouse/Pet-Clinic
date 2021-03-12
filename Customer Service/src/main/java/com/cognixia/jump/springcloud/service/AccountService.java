package com.cognixia.jump.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Account;

@Service
@FeignClient("account-service")
public interface AccountService {
	
	@GetMapping("/account/{accountId}")
	public Account findByAccountId(Integer accountId);
	
	@PostMapping("/account")
	public Account save(Account acct);

}

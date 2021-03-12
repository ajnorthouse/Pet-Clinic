package com.cognixia.jump.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognixia.jump.springcloud.model.Account;

@Component
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountService acctService;
	
	
	@GetMapping("/account/{accountId}")
	public Account findByAccountId(Integer accountId) {
		return null;
	}
	
	@PostMapping("/account")
	public Account save(Account acct) {
		return null;
	}

}

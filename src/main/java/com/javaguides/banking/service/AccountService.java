package com.javaguides.banking.service;

import java.util.List;

import com.javaguides.banking.Dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);

	AccountDto  getAccountById(Long id);

	AccountDto deposite(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);
	
	List<AccountDto> getAllAccount();
	
	void deleteAccount(Long id);
}

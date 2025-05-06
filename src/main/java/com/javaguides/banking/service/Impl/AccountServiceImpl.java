package com.javaguides.banking.service.Impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.javaguides.banking.Dto.AccountDto;
import com.javaguides.banking.entity.Account;
import com.javaguides.banking.mapper.AccountMapper;
import com.javaguides.banking.repository.AccountRepository;
import com.javaguides.banking.service.AccountService;



@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository; 
	
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override
	public AccountDto getAccountById(Long id) {
		
		Account account = accountRepository
				.findById(id).
				orElseThrow(() -> new RuntimeException("Account does not exists"));
		return AccountMapper.mapToAccountDto(account);
	}
	
	@Override
	
	public AccountDto deposite(Long id, double amount) {
		Account account = accountRepository
				.findById(id).
				orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository
				.findById(id).
				orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		if(account.getBalance() <amount) {
			throw new RuntimeException("Insufficient amount");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override 
	public java.util.List<AccountDto> getAllAccount() {
		
		java.util.List<Account> accounts = accountRepository.findAll();
		
		return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
	}



	@Override
	public void deleteAccount(Long id) {
		
		Account account = accountRepository
				.findById(id).
				orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		accountRepository.deleteById(id);
		
	}
	
	

}

package com.javaguides.banking.service.Impl;

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

}

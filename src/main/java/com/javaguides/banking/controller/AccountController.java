package com.javaguides.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javaguides.banking.Dto.AccountDto;
import com.javaguides.banking.service.AccountService;

@RestController
@RequestMapping("/api/account")

public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	// Add Account REST API
	@PostMapping
	public ResponseEntity<AccountDto>Account(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	//get Account REST API
	@GetMapping("/id")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable  Long id) {
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok (accountDto);
	}
	
	// Deposit REST API
	@PutMapping("/id/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable  Long id,
								@RequestBody Map<String, Double> request){
		
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposite(id,amount);
		return ResponseEntity.ok(accountDto);
	}
	
	// Withdraw REST API
		@PutMapping("/id/withdraw")
		public ResponseEntity<AccountDto> withdraw(@PathVariable  Long id,
									@RequestBody Map<String, Double> request){
			
			Double amount = request.get("amount");
			AccountDto accountDto = accountService.withdraw(id,amount);
			return ResponseEntity.ok(accountDto);
		}
		
		//Get All Account REST API
		@GetMapping
		public ResponseEntity<List<AccountDto>> getAllAccount(){
			List<AccountDto> account = accountService.getAllAccount();
			
			return ResponseEntity.ok(account);
		}
	
		//Delete All Account REST API
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteAccount( @PathVariable Long id){
			accountService.deleteAccount(id);
			
			return ResponseEntity.ok("Account is delete successfully");
		}
}


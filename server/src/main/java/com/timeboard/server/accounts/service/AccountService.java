package com.timeboard.server.accounts.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.timeboard.server.accounts.model.Account;
import com.timeboard.server.accounts.model.dto.AccountDto;
import com.timeboard.server.accounts.repository.AccountsRepository;
import com.timeboard.server.util.ServerException;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountService {

	@Autowired
	private AccountsRepository accountsRepository;

	@GetMapping
	public List<Account> getAllAccount() {
		return accountsRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") UUID id) throws RuntimeException {
		if (id == null) {
			throw new ServerException();
		}
		Account account = accountsRepository.findById(id).orElse(null);
		return account != null ?
				new ResponseEntity<>(account, HttpStatus.OK) :
				new ResponseEntity<>(account, HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody AccountDto account) {
		if (account == null) {
			throw new ServerException();
		}
		Account newAccount = new Account();
		newAccount.setId(UUID.randomUUID());
		newAccount.setLogin(account.getLogin());
		newAccount.setPassword(account.getPassword());
		newAccount.setCreationDate(ZonedDateTime.now());
		newAccount.setEmail(account.getEmail());
		newAccount.setFirstName(account.getFirstName());
		newAccount.setSecondName(account.getSecondName());
		// TODO: Save icon somewhere in cloud
		newAccount.setIconUrl(account.getIconUrl());
		newAccount = accountsRepository.save(newAccount);
		return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") UUID id, @RequestBody AccountDto account) {
		if (account == null || !account.getId().equals(id)) {
			throw new ServerException();
		}
		if (!accountsRepository.existsById(id)) {
			throw new ServerException();
		}
		Account oldAccount = accountsRepository
				.findById(id)
				.orElseThrow(ServerException::new);
		oldAccount.setLogin(account.getLogin());
		oldAccount.setPassword(account.getPassword());
		oldAccount.setEmail(account.getEmail());
		oldAccount.setFirstName(account.getFirstName());
		oldAccount.setSecondName(account.getSecondName());
		// TODO: Save icon somewhere in cloud
		oldAccount.setIconUrl(account.getIconUrl());
		accountsRepository.save(oldAccount);
		return new ResponseEntity<>(oldAccount, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable("id") UUID id) {
		if (id == null) {
			throw new ServerException();
		}
		accountsRepository.deleteById(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}

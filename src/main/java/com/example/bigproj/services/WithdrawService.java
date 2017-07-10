package com.example.bigproj.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.bigproj.daos.AccountDao;
import com.example.bigproj.model.Account;

@Transactional
@Service
public class WithdrawService {
	private final AccountDao dao;

	@Autowired
	public WithdrawService(AccountDao dao) {
		this.dao = dao;
	}
	

	public AccountDao getDao() {
		return dao;
	}


	@PreAuthorize("hasAuthority('ADMIN') or (this.dao.getTotalBalanceByCustomerName(#user).orElse(0.0) > #amount)")
	public void withdraw(String user, double amount){
		List<Account> accounts = dao.findAllByOwnerName(user);
		int x = accounts.size();
		double val = amount / x;
		for (Account account : accounts) {
			account.setBalance(account.getBalance() - val);
		}
		System.out.println("WITHDRAWING: " + val*x);
	}
}

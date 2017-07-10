package com.example.bigproj.daos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bigproj.model.Account;
import com.example.bigproj.model.Customer;

@Transactional
@Repository
public class BigFlow {
	private final AccountDao adao;
	private final CustomerDao cdao;

	@Autowired
	public BigFlow(AccountDao adao, CustomerDao cdao) {
		this.adao = adao;
		this.cdao = cdao;
	}
	
	public void insertAll() {
		Customer john = new Customer("John");
		Customer jane = new Customer("Jane");
		
		
		cdao.save(Arrays.asList(john, jane));
		
		Account a1 = new Account(john, 1000);
		Account a2 = new Account(john, 2000);
		Account a3 = new Account(jane, 6000);
		Account a4 = new Account(jane, 7000);
		adao.save(Arrays.asList(a1,a2,a3,a4));
		
	}
	
	
	
	
	
}

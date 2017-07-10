package com.example.bigproj.daos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bigproj.model.Account;
import com.example.bigproj.model.Customer;
import com.example.bigproj.model.UserRole;

@Transactional
@Repository
public class BigFlow {
	private final AccountDao adao;
	private final CustomerDao cdao;
	private final UserRoleDao rdao;

	@Autowired
	public BigFlow(AccountDao adao, CustomerDao cdao, UserRoleDao rdao) {
		this.adao = adao;
		this.cdao = cdao;
		this.rdao = rdao;
	}
	
	public void insertAll() {
		Customer john = new Customer("John", "Jane");
		Customer jane = new Customer("Jane", "John");
		Customer bob = new Customer("Bob", "sponge");
		
		
		cdao.save(Arrays.asList(john, jane, bob));
		
		Account a1 = new Account(john, 1000);
		Account a2 = new Account(john, 2000);
		Account a3 = new Account(jane, 6000);
		Account a4 = new Account(jane, 7000);
		adao.save(Arrays.asList(a1,a2,a3,a4));
		
		rdao.save(new UserRole("John", "REGULAR"));
		rdao.save(new UserRole("Jane", "REGULAR"));
		rdao.save(new UserRole("Bob", "ADMIN"));
		
	}
	
	
	
	
	
}

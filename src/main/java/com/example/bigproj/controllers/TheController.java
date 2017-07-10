package com.example.bigproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bigproj.daos.AccountDao;
import com.example.bigproj.services.WithdrawService;

@RestController
public class TheController {

	private final AccountDao dao;
	private final WithdrawService service;

	@Autowired
	public TheController(AccountDao dao, WithdrawService service) {
		this.dao = dao;
		this.service = service;
	}

	@RequestMapping(value="/total", method=RequestMethod.GET)
	public double getTotalBalance(@RequestParam("customer") String user) {
		return dao.getTotalBalanceByCustomerName(user).orElse(0.0);
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public int count() {
		return dao.findAll().size();
	}
	@RequestMapping(value="/withdraw", method=RequestMethod.PUT)
	public double withdraw(@RequestParam("customer") String user, @RequestParam("amount") double amount) {
		service.withdraw(user, amount);
		return getTotalBalance(user);
	}
	
	
	
}

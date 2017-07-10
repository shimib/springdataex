package com.example.bigproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bigproj.daos.AccountDao;

@RestController
public class TheController {

	private final AccountDao dao;

	@Autowired
	public TheController(AccountDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/total", method=RequestMethod.GET)
	public double getTotalBalance(@RequestParam("customer") String user) {
		return dao.getTotalBalanceByCustomerName(user).orElse(0.0);
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public int count() {
		return dao.findAll().size();
	}
	
	
	
}

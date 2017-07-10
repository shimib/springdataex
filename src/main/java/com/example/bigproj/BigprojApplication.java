package com.example.bigproj;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.bigproj.daos.AccountDao;
import com.example.bigproj.daos.CustomerDao;
import com.example.bigproj.model.Account;
import com.example.bigproj.model.Customer;

@SpringBootApplication
public class BigprojApplication {

	public static void main(String[] args) {
		BeanFactory bf = SpringApplication.run(BigprojApplication.class, args);
		CustomerDao cdao = bf.getBean(CustomerDao.class);
		AccountDao adao = bf.getBean(AccountDao.class);
		
		Customer john = new Customer("John");
		Customer jane = new Customer("John");
		
		
		cdao.save(Arrays.asList(john, jane));
		
		Account a1 = new Account(john, 1000);
		Account a2 = new Account(john, 2000);
		Account a3 = new Account(jane, 6000);
		Account a4 = new Account(jane, 7000);
		adao.save(Arrays.asList(a1,a2,a3,a4));
		
		
		
		System.out.println("********************************************");
		System.out.println(adao.count());
		
		
		
		
	}
}

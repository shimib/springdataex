package com.example.bigproj;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.bigproj.daos.AccountDao;
import com.example.bigproj.daos.BigFlow;
import com.example.bigproj.daos.CustomerDao;
import com.example.bigproj.model.Account;
import com.example.bigproj.model.Customer;

@SpringBootApplication
public class BigprojApplication {

	public static void main(String[] args) {
		BeanFactory bf = SpringApplication.run(BigprojApplication.class, args);
		BigFlow d = bf.getBean(BigFlow.class);
		AccountDao adao = bf.getBean(AccountDao.class);
		d.insertAll();

		System.out.println(adao.count());

	}
}

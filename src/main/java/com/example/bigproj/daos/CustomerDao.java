package com.example.bigproj.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bigproj.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long>{

}

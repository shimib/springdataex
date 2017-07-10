package com.example.bigproj.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bigproj.model.Account;
@Repository
public interface AccountDao extends JpaRepository<Account, Long>{

}

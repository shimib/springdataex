package com.example.bigproj.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bigproj.model.Account;
@Repository
public interface AccountDao extends JpaRepository<Account, Long>{
	  @Query("SELECT SUM(a.balance) FROM Account a WHERE a.owner.name = :name")
      Optional<Long> getTotalBalanceByCustomerName(@Param("name") String name);
}

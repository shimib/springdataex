package com.example.bigproj.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Repository;

import com.example.bigproj.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
	@Query("SELECT SUM(a.balance) FROM Account a WHERE a.owner.name = :name")
	Optional<Double> getTotalBalanceByCustomerName(@Param("name") String name);

	@Override
	@PostFilter("hasAuthority('ADMIN') or (filterObject.owner.name == authentication.name)")
	List<Account> findAll();
	
	List<Account> findAllByOwnerName(String name);

}

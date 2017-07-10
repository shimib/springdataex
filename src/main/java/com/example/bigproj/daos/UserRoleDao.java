package com.example.bigproj.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bigproj.model.UserRole;
@Repository
public interface UserRoleDao extends JpaRepository<UserRole	, Long>{

}

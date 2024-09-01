package com.fwitter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fwitter.models.ApplicationUser;
import java.util.List;


public interface UserRepository  extends JpaRepository<ApplicationUser, Integer>{
	Optional<ApplicationUser>  findByUsername(String username);
}

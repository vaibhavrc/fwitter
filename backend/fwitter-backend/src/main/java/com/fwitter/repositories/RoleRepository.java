package com.fwitter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fwitter.models.Role;
import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role>  findRoleByAuthority(String authority);
}

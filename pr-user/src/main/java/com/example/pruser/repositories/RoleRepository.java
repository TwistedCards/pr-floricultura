package com.example.pruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruser.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRoleName(String roleName);
}

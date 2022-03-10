package com.example.pruser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruser.entities.Role;
import com.example.pruser.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
}

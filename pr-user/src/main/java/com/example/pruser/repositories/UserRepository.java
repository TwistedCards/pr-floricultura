package com.example.pruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}

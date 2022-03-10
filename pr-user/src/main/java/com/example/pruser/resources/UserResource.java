package com.example.pruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruser.entities.User;
import com.example.pruser.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getById(id));
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity <User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(userService.getByEmail(email));
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return ResponseEntity.ok(userService.save(user));
	}
	
}

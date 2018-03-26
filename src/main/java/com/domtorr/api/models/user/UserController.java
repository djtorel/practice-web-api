package com.domtorr.api.models.user;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domtorr.api.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	// Get all Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	// Create a new User
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	// Get a single User
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") UUID userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "username", userId));
	}
	
	// Update a User
	
	// Delete a User

}

































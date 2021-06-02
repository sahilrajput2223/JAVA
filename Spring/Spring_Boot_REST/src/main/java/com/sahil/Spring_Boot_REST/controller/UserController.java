package com.sahil.Spring_Boot_REST.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.Spring_Boot_REST.User;
import com.sahil.Spring_Boot_REST.UserRepository;
import com.sahil.Spring_Boot_REST.exception.UserNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("apis")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	
	@ApiOperation(value = "Get All Users Data", notes = "All User Data")
	//Get All User
	@GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUser(){
		return repository.findAll();
	}
	
	//Create New User
	@PostMapping(value = "/newUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@Valid @RequestBody User user){
		return repository.save(user);
	}
	
	//Get Single User Data
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		return repository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
	}
	
	//Update user
	@PutMapping("users/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDeatils) {
		User user = repository.findById(userId).get();
		user.setUsername(userDeatils.getUsername());
		user.setEmail(userDeatils.getEmail());
		user.setContent(userDeatils.getContent());
		
		User updateUser = repository.save(user);
		return updateUser;
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId){
		User user = repository.findById(userId).get();
		repository.delete(user);
		
		return ResponseEntity.ok().build();
	}
	
}

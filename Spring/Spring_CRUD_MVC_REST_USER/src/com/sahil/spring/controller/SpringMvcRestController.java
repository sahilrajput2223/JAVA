package com.sahil.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sahil.spring.exception.NotFoundException;
import com.sahil.spring.model.User;
import com.sahil.spring.service.UserServiceImplimentation;

@RestController
public class SpringMvcRestController {

	@Autowired
	private UserServiceImplimentation userService;
	
	//All User API
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser(){
		System.out.println("All User Data API Called");
		List<User> allUser = userService.findAllUser();
		if(allUser.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	} 
	
	
	//Get User By ID API 
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		System.out.println("Get User By ID API CALL :: " + id);
		User user = userService.findById(id);
		
		if(user == null) {
			throw new NotFoundException("User Not Found With ID :: " + id);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
	
	
	//Create New User
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder){
		System.out.println("New User Creating Request For First Name :: " + user.getFirstName());
		
		if(userService.isUserExist(user)) {
			System.out.println("User Name Already Exist :: " + user.getFirstName());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
		System.out.println("Updating user with id : " + id);
		
		User currentUserInDb = userService.findById(id);
		
		if(currentUserInDb == null) {
			System.out.println("User with id : " + id + " Not Found");
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		currentUserInDb.setFirstName(user.getFirstName());
		currentUserInDb.setLastName(user.getLastName());
		currentUserInDb.setAge(user.getAge());
		currentUserInDb.setSalary(user.getSalary());
		
		userService.updateUser(currentUserInDb);
		return new ResponseEntity<User>(currentUserInDb, HttpStatus.OK);
	}
}

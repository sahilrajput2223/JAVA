package com.sahil.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sahil.spring.model.User;
import com.sahil.spring.service.UserServiceImplimentation;

@RestController
public class SpringRestController {

	@Autowired
	private UserServiceImplimentation implimentation;
	
	//All User
	@RequestMapping(value = "/user", method = RequestMethod.GET )
	public ResponseEntity<List<User>> listAllUser(){
		System.out.println("All User Request Called");
		List<User> users = implimentation.findAllUser();
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//User By Id
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") long id){
		System.out.println("Request to find user with ID : " + id);
		User user = implimentation.findById(id);
		if(user == null) {
			System.out.println("User not found with ID : " + id);	
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//Create New User
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder){
		System.out.println("Creating New User : " + user.getName());
		
		if(implimentation.isUserExist(user)) {
			System.out.println("User With name : " + user.getName() + " Already Exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		implimentation.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	
	//Update User
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		System.out.println("Updating user with id : " + id);
		
		User currentUser = implimentation.findById(id);
		
		if(currentUser==null) {
			System.out.println("User with id : " + id + " Not Found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());
		
		implimentation.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	//Delete User
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
		System.out.println("Deleting User with ID : " + id);
		
		User user = implimentation.findById(id);
		
		if(user == null) {
			System.out.println("Unable to delete user with id : " + id + " Not Available" );
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		implimentation.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	} 
	
	
	//Delete All User
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUser(){
		System.out.println("Deleting All User");
		implimentation.deleteAllUser();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}

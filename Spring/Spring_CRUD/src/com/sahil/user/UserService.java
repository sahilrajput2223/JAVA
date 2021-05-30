package com.sahil.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public List<User> allUser(){
		return (List<User>) repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User getUserById(long id) {
		return repo.findById(id).get();
	}
	
	public void deleteUser(long id){
		repo.deleteById(id);
	}
	
	public List<User> search(String word){
		return repo.search(word);
	}
}

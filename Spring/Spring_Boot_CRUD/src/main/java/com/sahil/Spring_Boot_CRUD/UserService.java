package com.sahil.Spring_Boot_CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> allUser(){
		return userRepository.findAll();
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public User getUserById(Long uId) {
		return userRepository.findById(uId).get();
	}
	
	public void deleteUser(Long uId) {
		userRepository.deleteById(uId);
	}
}

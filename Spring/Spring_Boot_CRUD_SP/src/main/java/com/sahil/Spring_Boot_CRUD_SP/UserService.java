package com.sahil.Spring_Boot_CRUD_SP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo userRepository;
	
	public List<User> allUser(){
		return userRepository.getAllUser();
	}
	
	public void addUser(User user) {
		userRepository.saveUser(user.getUsername(), user.getEmail(), user.getAddress());
	}
	
	public void updateUser(User user) {
		userRepository.updateUserData(user.getId(), user.getUsername(), user.getEmail(), user.getAddress());
	}
	
	public User getUserById(Long uId) {
		return userRepository.getUserById(uId);
	}
	
	public void deleteUser(Long uId) {
		userRepository.deleteUser(uId);
	}
}

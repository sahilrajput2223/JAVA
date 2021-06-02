package com.sahil.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	
	public void save(String username, String email, String address) {
		repository.addUserData(address, email, username);
	}
	
	public List<User> allUserData(){
		return repository.getAllUser();
	}
	
	public User getUserById(long id){
		return repository.getUserById(id);
	}
	
	public void delete(long id) {
		repository.deleteUserById(id);
	}
	
	public void updateUser(User user) {
		repository.updateUserData(user.getId(), user.getUsername(), user.getEmail(), user.getAddress());
	}
	
	public List<User> search(String searchKey){
		return repository.searchData(searchKey);
	}
	
}
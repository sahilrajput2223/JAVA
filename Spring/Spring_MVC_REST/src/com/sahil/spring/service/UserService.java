package com.sahil.spring.service;

import java.util.List;

import com.sahil.spring.model.User;

public interface UserService {

	User  findById(long id);
	User findByName(String name);
	void saveUser(User user);
	void updateUser(User user);
	void deleteUserById(long id);
	List<User> findAllUser();
	void deleteAllUser();
	public boolean isUserExist(User user);
}

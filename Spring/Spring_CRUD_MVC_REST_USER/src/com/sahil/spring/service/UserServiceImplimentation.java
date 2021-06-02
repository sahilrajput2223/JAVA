package com.sahil.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sahil.spring.model.User;

@Service
@Transactional
public class UserServiceImplimentation implements UserServices{

	private static final AtomicInteger Counter = new AtomicInteger();
	private static List<User> users;
	
	static {
		users = addDummyUserData();
	}
	
	
	private static List<User> addDummyUserData(){
		List<User> users = new ArrayList<User>();
		users.add(new User(Counter.getAndIncrement(), "Sahil", "Rajput", 22, 14785));
		users.add(new User(Counter.getAndIncrement(), "SDFS", "SFDSDf", 23, 15014));
		users.add(new User(Counter.getAndIncrement(), "qwerA", "ASFvcxc", 30, 10000));
		users.add(new User(Counter.getAndIncrement(), "fsdwes", "fdcxcsds", 24, 10500));
		return users;
	}
	
	
	//Find User By Id Method
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		for(User user: users) {
			if(user.getFirstName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setId(Counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		int index = users.indexOf(user);
		users.set(index, user);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		for(User user: users) {
			if(user.getId() == id) {
				int index = users.indexOf(user);
				users.remove(index);
			}
		}
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public void deleteAllUser() {
		// TODO Auto-generated method stub
		users.clear();
		
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return findByName(user.getFirstName()) != null;
	}

}

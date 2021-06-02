package com.sahil.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sahil.spring.model.User;

@Service("userService")
@Transactional
public class UserServiceImplimentation implements UserService{

	private static final AtomicLong Counter = new AtomicLong();
	private static List<User> users;
	
	static {
		users = addDummyUsers();
	}
	
	private static List<User> addDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(Counter.incrementAndGet(), "sahil", 22, 15000));
		users.add(new User(Counter.incrementAndGet(), "abc", 25, 20000));
		users.add(new User(Counter.incrementAndGet(), "xyz", 21, 10000));
		users.add(new User(Counter.incrementAndGet(), "pqr", 28, 30000));
		return users;
	}
	
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		for(User user : users) {
			if(user.getName().equalsIgnoreCase(name)) {
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
		for(Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
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
		return findByName(user.getName())!=null;
	}

}

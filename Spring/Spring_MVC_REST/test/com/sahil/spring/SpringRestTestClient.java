package com.sahil.spring;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.sahil.spring.model.User;

public class SpringRestTestClient {

	public static final String REST_URL = "http://localhost:5544/Spring_MVC_REST";
	
	//Get All User API Test (GET)
	@SuppressWarnings("unchecked")
	private static void allUser() {
		System.out.println("<-----  TESTING ALL USER API ----->");
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> userMap = restTemplate.getForObject(REST_URL+"/user", List.class);
		
		if(userMap != null) {
			for(LinkedHashMap<String, Object> map : userMap) {
				System.out.println("User  --->   id = " + map.get("id") + ", name = " + map.get("name") + ", age = " + map.get("age") + ", salary = " + map.get("salary"));
			}
		}else {
			System.out.println("<----- NO USER EXIST------>");
		}
 	}
	
	
	//Get User By Id, API Test (GET)
	private static void getUser() {
		System.out.println("<----- TESTING GET USER BY ID API----->");
		RestTemplate  restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(REST_URL+"/user/1", User.class);
		System.out.println(user);
	}
	
	//Create new User API Test (POST)
	private static void createUser() {
		System.out.println("<----- TESTING CREATE USER API ----->");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(0,"SAHIL RAJPUT",22,12000);
		URI uri = restTemplate.postForLocation(REST_URL+"/user", user, User.class);
		System.out.println("Location : " + uri.toASCIIString());
	}
	
	//Update User API Test (PUT)
	public static void updateUser() {
		System.out.println("<----- TESTING UPDATE USER BY ID API ----->");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(1,"ABCD",21,30000);
		restTemplate.put(REST_URL+"/user/1", user);
		System.out.println(user);
	}
	
	//Delete User By Id API Test (DELETE) 
	public static void deleteUserById() {
		System.out.println("<----- TESTING DELETE USER BY ID API----->");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_URL+"/user/5");
	}
	
	//Delete All User API Test (DELETE)
	public static void deleteAllUser() {
		System.out.println("<----- TESTING ALL USER DELETE API ----->");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_URL+"/user");
	}
	
	public static void main(String args[]) {
		allUser();
		System.out.println();
		getUser();
		System.out.println();
		createUser();
		System.out.println();
		updateUser();
		System.out.println();
		allUser();
		System.out.println();
		deleteUserById();
		System.out.println();
		allUser();
		System.out.println();
		deleteAllUser();
		System.out.println();
		allUser();
	}
}

package com.sahil.Spring_Boot_CRUD_SP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends JpaRepository<User, Long>{

	@Query(value = "CALL SP_allUser", nativeQuery = true)
	public List<User> getAllUser();

	@Query(value = "CALL SP_getUserById(:id)", nativeQuery = true)
	public User getUserById(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = "CALL SP_addUser(:username, :email, :address)", nativeQuery = true)
	public void saveUser(@Param("username") String username, @Param("email") String email, @Param("address") String address);
	
	@Transactional
	@Modifying
	@Query(value = "CALL SP_userDelete(:id)", nativeQuery = true)
	public void deleteUser(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = "CALL SP_userById(:id, :username, :email, :address)", nativeQuery = true)
	public void updateUserData(@Param("id") Long id, @Param("username") String username, @Param("email") String email, @Param("address") String address);
}

package com.sahil.user;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Long>{

	@Query(value = "CALL SP_AllUserData", nativeQuery = true)
	public List<User> getAllUser();
	
	@Query(value = "CALL SP_UserById(:ID)", nativeQuery = true)
	public User getUserById(@Param("ID") long id);
	
	@Transactional
	@Modifying
	@Query(value = "CALL SP_delete(:uId)", nativeQuery = true)
	public void deleteUserById(@Param("uId") long id);
	
	@Transactional
	@Modifying
	@Query(value = "{CALL SP_addUser(:address, :email, :username)}", nativeQuery = true)
	public void addUserData(@Param("address") String address, @Param("email") String email, @Param("username") String username);
	
	
	@Transactional
	@Modifying
	@Query(value = "{CALL SP_updateUser(:ID, :username, :email, :address)}", nativeQuery = true)
	public void updateUserData(@Param("ID") long id, @Param("username") String username, @Param("email") String email, @Param("address") String address);

	@Query(value = "{CALL SP_search(:searchKey)}", nativeQuery = true)
	public List<User> searchData(@Param("searchKey") String key);
}

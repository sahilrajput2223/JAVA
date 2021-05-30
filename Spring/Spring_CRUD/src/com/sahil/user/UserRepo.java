package com.sahil.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, Long>{

	@Query(value = "SELECT u FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(u.email) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(u.address) LIKE LOWER(CONCAT('%',:word,'%'))")
	public List<User> search(@Param("word") String Word); 
}

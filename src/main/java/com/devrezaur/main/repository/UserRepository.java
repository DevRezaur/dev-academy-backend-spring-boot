package com.devrezaur.main.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.devrezaur.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	
	@Query(value = "SELECT u FROM User u JOIN u.roles r WHERE r.id = 2")
	List<User> getAllUser();

}

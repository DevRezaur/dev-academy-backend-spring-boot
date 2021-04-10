package com.devrezaur.main.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.devrezaur.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	
	@Query(value = "SELECT u FROM User u JOIN u.roles r WHERE r.id = 2")
	List<User> getAllUser();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE users SET img_url=?2 WHERE user_id=?1", nativeQuery = true)
	void updateImage(int id, String imageUrl);

}

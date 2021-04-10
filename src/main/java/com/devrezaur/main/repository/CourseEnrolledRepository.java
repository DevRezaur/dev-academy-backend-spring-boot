package com.devrezaur.main.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.devrezaur.main.model.CourseEnrolled;

@Repository
public interface CourseEnrolledRepository extends JpaRepository<CourseEnrolled, Integer> {
	
	@Query(value = "SELECT * FROM course_enrolled WHERE user_id = ?1", nativeQuery = true)
	List<CourseEnrolled> getEnrolledCourses(int userId);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM course_enrolled WHERE user_id = ?1 and course_id = ?2", nativeQuery = true)
	void unenroll(int userId, int courseId);
}

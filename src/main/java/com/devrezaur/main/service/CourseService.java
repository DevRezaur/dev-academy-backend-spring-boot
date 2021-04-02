package com.devrezaur.main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.model.Post;
import com.devrezaur.main.repository.CourseRepository;
import com.devrezaur.main.repository.PostRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private PostRepository postRepo;
	
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}
	
	public Post createPost(Post post) {
		return postRepo.save(post);
	}
	
}

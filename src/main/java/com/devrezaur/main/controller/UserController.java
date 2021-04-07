package com.devrezaur.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.model.Post;
import com.devrezaur.main.service.CourseService;
import com.devrezaur.main.service.PostService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "Hello... User....Welcome to Dashboard";
	}
	
	@GetMapping("/{courseId}/getPost")
	public List<Post> getPost(@PathVariable("courseId") int courseId) {
		return postService.getPosts(courseId);
	}
	
	@GetMapping("/{userId}/getCourses")
	public List<Course> getEnrolledCourses(@PathVariable("userId") int userId) {
		return courseService.getEnrolledCourse(userId);
	}
}

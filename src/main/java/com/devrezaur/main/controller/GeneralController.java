package com.devrezaur.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.service.CourseService;

@RestController
@RequestMapping("/general")
public class GeneralController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/course/getAll")
	public ResponseEntity<?> getAllCourse() {
		List<Course> allCourse = courseService.getAllCourses();
		
		return ResponseEntity.ok().body(allCourse);
	}

}

package com.devrezaur.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.service.CourseService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/dashboard")
	public String dashboard() {
		return "Hello... admin....Welcome to Dashboard";
	}

	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

}

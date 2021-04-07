package com.devrezaur.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.model.CourseEnrolled;
import com.devrezaur.main.repository.CourseEnrolledRepository;
import com.devrezaur.main.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private CourseEnrolledRepository courseEnrolledRepo;
	
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}
	
	public Optional<Course> getCourse(int courseId) {
		return courseRepo.findById(courseId);
	}
	
	public List<Course> getEnrolledCourse(int userId) {
		List<CourseEnrolled> enrolledCourses = courseEnrolledRepo.getEnrolledCourses(userId);
		List<Course> courses = new ArrayList<Course>();
		
		for(CourseEnrolled ce : enrolledCourses) {
			Optional<Course> course = courseRepo.findById(ce.getCourseId());
			course.ifPresent(courses::add);
		}
		
		return courses;
	}
	
}

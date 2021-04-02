package com.devrezaur.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.service.CourseService;
import com.devrezaur.main.service.FileService;

@RestController
@RequestMapping("/general")
public class GeneralController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private FileService fileService;
	
	@PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@ModelAttribute MultipartFile file) {
		String path = null;
		try {
			path = fileService.uploadFile(file);
		} catch (Exception e) {
			System.out.println("Error uploading file" + e);
		}

		return ResponseEntity.ok().body(path);
    }
	
	@GetMapping("/course/getAll")
	public ResponseEntity<?> getAllCourse() {
		List<Course> allCourse = courseService.getAllCourses();
		
		return ResponseEntity.ok().body(allCourse);
	}

}

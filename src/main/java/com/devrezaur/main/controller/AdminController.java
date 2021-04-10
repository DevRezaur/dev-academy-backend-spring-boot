package com.devrezaur.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.model.Payment;
import com.devrezaur.main.model.Post;
import com.devrezaur.main.service.CourseService;
import com.devrezaur.main.service.PaymentService;
import com.devrezaur.main.service.PostService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private PostService postService;
	@Autowired
	private PaymentService paymentService;

	@GetMapping("/dashboard")
	public ResponseEntity<?> dashboard() {
		return ResponseEntity.ok().body("Hello... admin....Welcome to Dashboard");
	}

	@PostMapping("/addCourse")
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		course = courseService.addCourse(course);
		
		return ResponseEntity.ok().body(course);
	}
	
	@PostMapping("/createPost")
	public ResponseEntity<?> createPost(@RequestBody Post post) {
		post = postService.createPost(post);
		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/payments")
	public List<Payment> getPayments() {
		return paymentService.getPayments();
	}
	
	@PostMapping("/update/payment")
	public Payment updatePayment(@RequestBody Payment payment) {
		courseService.updateEnrollStatus(payment.getUserId(), payment.getCourseId(), payment.getStatus());
		return paymentService.pay(payment);
	}

}
package com.devrezaur.main.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.JwtResponse;
import com.devrezaur.main.model.Role;
import com.devrezaur.main.model.User;
import com.devrezaur.main.service.UserService;
import com.devrezaur.main.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		User regUser = userService.findUserByEmail(user.getEmail());
		
		if(regUser != null)
			return ResponseEntity.badRequest().body("User already exists !");
		
		regUser = userService.saveUser(user);
		
		return ResponseEntity.ok().body(regUser);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {
		Authentication auth = null;
		
		try {
			auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (BadCredentialsException e) {
			return ResponseEntity.badRequest().body("Incorrect credentials !");
		}
		
		final String jwt = jwtUtil.generateToken(auth);

		return ResponseEntity.ok(new JwtResponse(jwt));
	}
	
	@PostMapping("/userinfo")
	public ResponseEntity<?> getUserInfo(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String token = "";
		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
			token = authorizationHeader.substring(7);
		
		try {
			if (jwtUtil.validateToken(token)) {
				String username = jwtUtil.extractUsername(token);
				User user = userService.findUserByEmail(username);
				
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			System.out.println("Invalid JWT");
		}
		
		return ResponseEntity.badRequest().body("Incorrect credentials !");
	}
	
	@PostMapping("/updateInfo")
	public ResponseEntity<?> updateUserInfo(@RequestBody User user) {
		User existingUser = userService.findUserByEmail(user.getEmail());
		user.setId(existingUser.getId());
		user.setImageUrl(existingUser.getImageUrl());
		
		for(Role role : existingUser.getRoles())
		{
			if(role.getId() == 1)
				user = userService.saveAdmin(user);
			else if(role.getId() == 2)
				user = userService.saveUser(user);
		}
		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/updateImage")
	public ResponseEntity<?> updateUserImage(@RequestBody User user) {
		userService.updateImage(user.getId(), user.getImageUrl());
		return ResponseEntity.ok().body("Upload Successful");
	}

}

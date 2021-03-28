package com.devrezaur.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.AppUser;
import com.devrezaur.main.model.JwtResponse;
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
	public ResponseEntity<?> register(@RequestBody AppUser appUser) {
		User user = userService.findUserByEmail(appUser.getEmail());
		
		if(user != null)
			return ResponseEntity.badRequest().body("User already exists !");
		
		appUser = userService.saveUser(appUser);
		
		return ResponseEntity.ok().body(appUser);	
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
		
		User user = new User();
		
		try {
			if (jwtUtil.validateToken(token)) {
				String username = jwtUtil.extractUsername(token);
				user = userService.findUserByEmail(username);
				
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			System.out.println("Invalid JWT");
		}
		
		return ResponseEntity.badRequest().body("Incorrect credentials !");
	}

}

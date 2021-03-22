package com.devrezaur.main.service;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.devrezaur.main.model.AppUser;
import com.devrezaur.main.model.Role;
import com.devrezaur.main.model.User;
import com.devrezaur.main.repository.AppUserRepository;
import com.devrezaur.main.repository.RoleRepository;
import com.devrezaur.main.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public AppUser saveUser(AppUser appUser) {
		User user = new User();
		user.setEmail(appUser.getEmail());
		user.setPassword(passwordEncoder.encode(appUser.getPassword()));
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user = userRepository.save(user);
        
        appUser.setId(user.getId());
        appUser = appUserRepository.save(appUser);
        
        return appUser;
	}

}
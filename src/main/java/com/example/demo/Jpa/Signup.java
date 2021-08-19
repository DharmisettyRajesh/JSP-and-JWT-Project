package com.example.demo.Jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Signup { 
	@Autowired
	UserRepository ur;
	@PostMapping("/signup")
	public User addUser(@RequestBody User u)
	{ 
		String password=new BCryptPasswordEncoder().encode(u.getPassword());
		u.setPassword(password);
		return  ur.save(u);
	}

}

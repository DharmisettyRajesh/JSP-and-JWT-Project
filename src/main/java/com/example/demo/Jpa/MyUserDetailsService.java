package com.example.demo.Jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		com.example.demo.Jpa.User user=repo.findByName(name);  
		System.out.println(name);
		if(user==null)
			 throw new UsernameNotFoundException("User doesnot exists");
		return new UserPrincipal(user);
	} 
}

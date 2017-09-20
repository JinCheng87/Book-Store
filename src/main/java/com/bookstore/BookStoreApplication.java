package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.domain.User;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService;
import com.bookstore.utility.SecurityUtility;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		User user1 = new User();
		user1.setFirstName("Jin");
		user1.setLastName("Cheng");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("sw6342716@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role));
		
		userService.createUser(user1, userRoles);
	}
}

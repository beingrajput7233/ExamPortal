package com.exam.examserver;

import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Coding started");


		User user=new User();

		user.setFirstName("Ashutosh");
		user.setLastName("Singh");
		user.setUsername("ashutosh7233");
		user.setPassword("abc");
		user.setEmail("abc@gmail.com");
		user.setProfile("picture.png");

		Role role1=new Role();
		role1.setRoleId(1L);
		role1.setRoleName("Admin");

		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);

		User user1=this.userService.createUser(user,userRoleSet);
		System.out.println(user1.getUsername());


	}
}

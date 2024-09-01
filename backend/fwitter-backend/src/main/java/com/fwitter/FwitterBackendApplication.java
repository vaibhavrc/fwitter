package com.fwitter;

import java.util.HashSet;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fwitter.models.ApplicationUser;
import com.fwitter.models.Role;
import com.fwitter.repositories.RoleRepository;

import com.fwitter.services.UserService;

@SpringBootApplication
public class FwitterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FwitterBackendApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepo,UserService userService) {
		return args ->{
			roleRepo.save(new Role(1,"USER"));
//			ApplicationUser testUser=new ApplicationUser();
//			testUser.setFirstName("unknown");
//			testUser.setLastName("coder");
//			
//			userService.registerUser(testUser);
		};
	}

}

package com.fwitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fwitter.dto.RegistrationDTO;
import com.fwitter.exceptions.EmailAlreadyTakenException;
import com.fwitter.models.ApplicationUser;
import com.fwitter.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	private final UserService userService;
	
	@Autowired
	public AuthenticationController(UserService userService) {
		this.userService=userService;
	}
	
	@ExceptionHandler({EmailAlreadyTakenException.class})
	public ResponseEntity<String> handleEmailTaken(){
		return new ResponseEntity<String>("Email already taken",HttpStatus.CONFLICT);
	}
	
	@PostMapping("/register")
	public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {
		return userService.registerUser(registrationDTO);
	}
}

package com.fwitter.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwitter.dto.RegistrationDTO;
import com.fwitter.exceptions.EmailAlreadyTakenException;
import com.fwitter.models.ApplicationUser;
import com.fwitter.models.Role;
import com.fwitter.repositories.RoleRepository;
import com.fwitter.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	@Autowired
	public UserService(UserRepository userRepository,RoleRepository roleRepository) {
		this.userRepository=userRepository;
		this.roleRepository=roleRepository;
	}
	
	public ApplicationUser registerUser(RegistrationDTO registrationDTO) {
		ApplicationUser user=new ApplicationUser();
		
		user.setFirstName(registrationDTO.getFirstName());
		user.setLastName(registrationDTO.getLastName());
		user.setEmail(registrationDTO.getEmail());
		user.setDateOfBirth(registrationDTO.getDateOfBirth());
		
		//Generate random username
		String nameString=user.getFirstName()+user.getLastName();
		boolean nameTaken=true;
		String tempNameString="";
		while(nameTaken) {
			tempNameString=generateUsername(nameString);
			if(userRepository.findByUsername(tempNameString).isEmpty()) {
				nameTaken=false;
			}
		}
		user.setUsername(tempNameString);
		
		Set<Role> roles = user.getAuthorities();
		roles.add(roleRepository.findRoleByAuthority("USER").get());
		user.setAuthorities(roles);
		
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new EmailAlreadyTakenException();
		}
	}
	
	public String generateUsername(String name) {
		long generatedNumber=(long) Math.floor(Math.random()*1000000000);
		return name+generatedNumber;
	}
	
}

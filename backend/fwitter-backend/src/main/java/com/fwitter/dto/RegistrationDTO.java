package com.fwitter.dto;

import java.sql.Date;

public class RegistrationDTO {
	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;
	public RegistrationDTO() {
		super();
	}
	public RegistrationDTO(String firstName, String lastName, String email, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "RegistrationDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}

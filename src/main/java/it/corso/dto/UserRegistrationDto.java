package it.corso.dto;

import jakarta.validation.constraints.Pattern;


public class UserRegistrationDto {
	
	private int id;
	@Pattern(regexp="[a-zA-Z\\s']{1,50}", message="nome non corretto")
	private String name;
	@Pattern(regexp="[a-zA-Z\\s']{1,50}", message="cognome non corretto")
	private String lastname;
	@Pattern(regexp = "[A-Za-z0-9\\.\\+_-]+@[A-Za-z0-9\\._-]+\\.[A-Za-z]{2,24}", message="email non valida")
	private String email;
	private String city;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}

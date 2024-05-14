package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_u")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Weather> weatherForecast = new ArrayList<>();

	
	//getters e setters
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public List<Weather> getWeatherForecast() {
		return weatherForecast;
	}

	public void setWeatherForecast(List<Weather> weatherForecast) {
		this.weatherForecast = weatherForecast;
	}
	
	
	
}
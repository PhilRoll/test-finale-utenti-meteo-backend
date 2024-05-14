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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable
	(
			name = "user_weather", 
			joinColumns = @JoinColumn(name = "fk_u", referencedColumnName = "id_u"),
			inverseJoinColumns = @JoinColumn(name = "fk_w", referencedColumnName = "id_w")
	) 
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
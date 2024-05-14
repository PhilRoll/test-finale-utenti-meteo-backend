package it.corso.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "weather")
public class Weather {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_w")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "day")
	private Date day;
	
	@Column(name = "forecast_text")
	private String forecastText;
	
	@Column(name = "max_temp_celsius")
	private Double maxTempCelsius;
	
	@Column(name = "min_temp_celsius")
	private Double minTempCelsius;
	
	@Column(name = "wind_average_kmh")
	private Double windAverageKmh;
	
	

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable
	(
			name = "user_weather", 
			joinColumns = @JoinColumn(name = "fk_w", referencedColumnName = "id_w"),
			inverseJoinColumns = @JoinColumn(name = "fk_u", referencedColumnName = "id_u")
	) 
	private List<User> users = new ArrayList<>();



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



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Date getDay() {
		return day;
	}



	public void setDay(Date day) {
		this.day = day;
	}



	public String getForecastText() {
		return forecastText;
	}



	public void setForecastText(String forecastText) {
		this.forecastText = forecastText;
	}



	public Double getMaxTempCelsius() {
		return maxTempCelsius;
	}



	public void setMaxTempCelsius(Double maxTempCelsius) {
		this.maxTempCelsius = maxTempCelsius;
	}



	public Double getMinTempCelsius() {
		return minTempCelsius;
	}



	public void setMinTempCelsius(Double minTempCelsius) {
		this.minTempCelsius = minTempCelsius;
	}



	public Double getWindAverageKmh() {
		return windAverageKmh;
	}



	public void setWindAverageKmh(Double windAverageKmh) {
		this.windAverageKmh = windAverageKmh;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	
	
}

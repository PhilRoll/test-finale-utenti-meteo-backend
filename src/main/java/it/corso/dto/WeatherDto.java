package it.corso.dto;

import java.util.Date;
import java.util.List;

public class WeatherDto {
	
	private int id;
	private String name;	
	private String country;
	private Date day;
	private String forecastText;
	private Double maxTempCelsius;
	private Double minTempCelsius;
	private Double windAverageKmh;
	UserDto user;
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
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
	
	
	
}

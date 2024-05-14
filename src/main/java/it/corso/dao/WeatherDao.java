package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Weather;

public interface WeatherDao extends CrudRepository<Weather, Integer>{
	
	
}
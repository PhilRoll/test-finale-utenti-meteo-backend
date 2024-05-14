package it.corso.service;

import java.util.List;

import it.corso.dto.UserWeatherDto;
import it.corso.dto.WeatherDto;

public interface WeatherService {
	boolean registerWeather(WeatherDto weatherDto);
	List<UserWeatherDto> getCronologyByUserId(int userId);
}

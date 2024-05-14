package it.corso.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UserDao;
import it.corso.dao.WeatherDao;
import it.corso.dto.WeatherDto;
import it.corso.model.User;
import it.corso.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherDao weatherDao;
	
	//private ModelMapper mapper = new ModelMapper();

	
	@Override
	public void registerWeather(WeatherDto weatherDto) {
		Weather weather = new Weather();
		
		weather.setName(weatherDto.getName());
		weather.setCountry(weatherDto.getCountry());
		weather.setDay(weatherDto.getDay());
		weather.setForecastText(weatherDto.getForecastText());
		weather.setMaxTempCelsius(weatherDto.getMaxTempCelsius());
		weather.setMinTempCelsius(weatherDto.getMinTempCelsius());
		weather.setWindAverageKmh(weatherDto.getWindAverageKmh());
		
		weatherDao.save(weather);
	}

	
}

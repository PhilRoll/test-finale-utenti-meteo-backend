package it.corso.service;

import java.util.Optional;

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
	
	@Autowired
	private UserDao userDao;
	
	//private ModelMapper mapper = new ModelMapper();

	
	@Override
	public boolean registerWeather(WeatherDto weatherDto) {
		Weather weather = new Weather();
		
		Optional<User> userDb = userDao.findById(weatherDto.getUserId());
		if(userDb.isPresent()) {
			User user = userDb.get();
			weather.setName(weatherDto.getName());
			weather.setCountry(weatherDto.getCountry());
			weather.setDay(weatherDto.getDay());
			weather.setForecastText(weatherDto.getForecastText());
			weather.setMaxTempCelsius(weatherDto.getMaxTempCelsius());
			weather.setMinTempCelsius(weatherDto.getMinTempCelsius());
			weather.setWindAverageKmh(weatherDto.getWindAverageKmh());
			weather.setUser(user);
			weatherDao.save(weather);
			
			return true;
		}
		
		return false;
		
	}

	
}

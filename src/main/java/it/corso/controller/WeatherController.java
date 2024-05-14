package it.corso.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import it.corso.dto.UserRegistrationDto;
import it.corso.dto.WeatherDto;
import it.corso.service.WeatherService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerWeather(@Valid @RequestBody WeatherDto weatherDto){
		try {
			if(weatherService.registerWeather(weatherDto)) {
				return Response.status(Response.Status.OK).build();
			}
			
			return Response.status(Response.Status.BAD_REQUEST).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	


}

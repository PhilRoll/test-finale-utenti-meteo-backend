package it.corso.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserLoginResponseDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.model.User;
import it.corso.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Path("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
		try {
			if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}", userRegistrationDto.getPassword())){
				return Response.status(Response.Status.BAD_REQUEST).build();
				
			}
			
			if(userService.existsUser(userRegistrationDto.getEmail())){
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			
			userService.registerUser(userRegistrationDto);
			return Response.status(Response.Status.OK).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUtente(@RequestBody UserLoginRequestDto userLoginRequestDto){
		
		try {
			if(userService.loginUser(userLoginRequestDto)){
				return Response.ok(issueToken(userLoginRequestDto.getEmail())).build();
			}
			
			return Response.status(Response.Status.BAD_REQUEST).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	
	
	
	
	
	private UserLoginResponseDto issueToken(String email) {
		byte[] secretKey = "supersecretkeytestfinale123456789101112131415161718192021222324252627282930".getBytes();
		Key key = Keys.hmacShaKeyFor(secretKey);
		User userInfo = userService.getUserByEmail(email);

		Map<String, Object> map = new HashMap<>();
		map.put("name", userInfo.getName());
		map.put("lastname", userInfo.getLastname());
		map.put("email", email);
		map.put("city",  userInfo.getCity());
		map.put("id",  userInfo.getId());
		
		List<String> weatherForecast = new ArrayList<>();
		userInfo.getWeatherForecast().forEach(weather -> weatherForecast.add(weather.getName()));
		map.put("weatherForecast", weatherForecast);
		

		Instant now = Instant.now();
		Date creationDate = Date.from(now); 					//data creazione
		Date end = Date.from(now.plus(60, ChronoUnit.MINUTES)); //TTL di 60min
		

		String jwtToken = Jwts.builder()
		    .setClaims(map)                     
		    .setIssuer("http://localhost:8080") 
		    .setIssuedAt(creationDate)         
		    .setExpiration(end)                 
		    .signWith(key)                     
		    .compact();                         

		
		UserLoginResponseDto token = new UserLoginResponseDto();
		token.setToken(jwtToken);                
		token.setTokenCreationTime(creationDate);   
		token.setTtl(end);                         


		return token;
	}


}

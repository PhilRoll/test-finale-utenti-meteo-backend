package it.corso.service;

import it.corso.dto.UserDto;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.model.User;


public interface UserService {
	
	void registerUser(UserRegistrationDto userRegistrationDto);
	
	boolean loginUser(UserLoginRequestDto userLoginRequestDto);

	boolean existsUser(String email);

	User getUserByEmail(String email);
	
	UserDto getUserDtoByEmail(String email);
	
}

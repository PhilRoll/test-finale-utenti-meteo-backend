package it.corso.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UserDao;
import it.corso.dto.UserDto;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	
	

	@Override
	public void registerUser(UserRegistrationDto userRegistrationDto) {
		User user = new User();
		user.setName(userRegistrationDto.getName());
		user.setLastname(userRegistrationDto.getLastname());
		user.setEmail(userRegistrationDto.getEmail());
		user.setCity(userRegistrationDto.getCity());
		
		String sha256hex = DigestUtils.sha256Hex(userRegistrationDto.getPassword());
		user.setPassword(sha256hex);
		userDao.save(user);
	}
	
	

	@Override
	public boolean loginUser(UserLoginRequestDto userLoginRequestDto) {
		User user = new User();
		user.setEmail(userLoginRequestDto.getEmail());
		user.setPassword(userLoginRequestDto.getPassword());
		
		String passwordHash = DigestUtils.sha256Hex(user.getPassword());
		User exists = userDao.findByEmailAndPassword(user.getEmail(), passwordHash);
		return exists != null ? true : false;
	}
	
	
	

	@Override
	public boolean existsUser(String email) {
		return userDao.existsByEmail(email);
	}

	
	@Override
	public User getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}



	@Override
	public UserDto getUserDtoByEmail(String email) {
		User user = userDao.findByEmail(email);
		return mapper.map(user, UserDto.class);
	}
	
	
}

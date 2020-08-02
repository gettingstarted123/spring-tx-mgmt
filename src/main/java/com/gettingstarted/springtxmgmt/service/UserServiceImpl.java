package com.gettingstarted.springtxmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gettingstarted.springtxmgmt.dto.UserDto;



@Service
public class UserServiceImpl implements UserService {
	
	//@Autowired
	//private UserRepository userRepository;

	@Override
	public UserDto save(UserDto user) {
		//userRepository.save(user);
		return user;
	}

}

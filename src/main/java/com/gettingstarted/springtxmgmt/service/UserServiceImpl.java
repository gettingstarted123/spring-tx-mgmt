package com.gettingstarted.springtxmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gettingstarted.springtxmgmt.dao.UserDao;
import com.gettingstarted.springtxmgmt.dto.UserDto;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean save(UserDto user) {
		return userDao.createUser(user);
		
	}

}

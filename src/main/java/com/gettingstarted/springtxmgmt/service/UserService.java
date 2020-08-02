package com.gettingstarted.springtxmgmt.service;

import com.gettingstarted.springtxmgmt.dto.UserDto;

public interface UserService {
	UserDto save(UserDto user);
}

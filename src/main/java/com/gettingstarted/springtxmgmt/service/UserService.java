package com.gettingstarted.springtxmgmt.service;

import com.gettingstarted.springtxmgmt.dto.UserDto;

public interface UserService {
	boolean save(UserDto user);
}

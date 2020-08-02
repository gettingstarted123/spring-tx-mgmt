package com.gettingstarted.springtxmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gettingstarted.springtxmgmt.dto.UserDto;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private com.gettingstarted.springtxmgmt.service.UserService userService;
	
	@PostMapping(path="/create")	
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
		final String METHOD_NAME = "createUser";	
		
		try {	
			userService.save(null);
			return ResponseEntity.status(200).body("done");
		}catch(Exception e) {
			/** this will catch any unexpected exceptions and also if DAO throws SQLException which will come as a runtime exception **/
			return ResponseEntity.status(500).body(e.getMessage());
		}

	}
}

package com.bridgelabz.spring.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.spring.model.UserDetails;
import com.bridgelabz.spring.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Void> registerUser(@RequestBody UserDetails user, HttpServletRequest request) {
			try {
				if (userService.register(user, request))
					return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
}

	}


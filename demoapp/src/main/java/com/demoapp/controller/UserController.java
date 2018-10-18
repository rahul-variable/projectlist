package com.demoapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.service.impl.UserService;
import com.demoapp.vo.UserVO;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService userServiceImpl;
	
//	@GetMapping("/create")
//	public UserVO createUser(@RequestBody UserVO userVO) {
//		return userServiceImpl.createUser(userVO);
//	}
	
	@PostMapping("/create")
	public UserVO createUser(@Valid @RequestBody UserVO userVO) {
		return userServiceImpl.createUser(userVO);
	}
}

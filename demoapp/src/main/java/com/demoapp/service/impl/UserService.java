package com.demoapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.dao.impl.UserDao;
import com.demoapp.service.UserServiceImpl;
import com.demoapp.vo.UserVO;

@Service
public class UserService implements UserServiceImpl{

	@Autowired
	UserDao userDaoImpl;
	
	@Override
	public UserVO createUser(UserVO userVO) {
		// TODO Auto-generated method stub
		userVO=userDaoImpl.saveUser(userVO);
		return userVO;
	}

}

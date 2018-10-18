package com.demoapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demoapp.entity.User;
import com.demoapp.vo.UserVO;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;
	
	public UserVO saveUser(UserVO userVO) {
		User user=new User();
		user.setFirstName(userVO.getFirstName());
		user.setLastName(userVO.getLastName());
		em.persist(user);
		em.flush();
		userVO.setId(user.getId());
		return userVO;
	}
}

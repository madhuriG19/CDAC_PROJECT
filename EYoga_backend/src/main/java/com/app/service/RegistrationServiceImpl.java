package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;
import com.app.repository.RegistrationRepository;

@Service
@Transactional
public class RegistrationServiceImpl  {
	// dependency
	@Autowired
	private RegistrationRepository dao;
	
	public User saveUser(User user) {
		 return dao.save(user);
		
	}
	public User fetchUserByEmail(String email) {
		return dao.findByEmail(email);
		
	}
	public User fetchUserByEmailAndPaasword(String email,String password) {
		return dao.findByEmailAndPassword(email,password);
		
	}
	
}
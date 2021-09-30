package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Manager;

public interface ManagerRepository extends JpaRepository <Manager, Integer>
{
	 //search by Manager name 
		//Manager  findByFirstName (String firstName);
	    Manager findById(int id);

}


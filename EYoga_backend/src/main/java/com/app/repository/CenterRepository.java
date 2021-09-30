package com.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Center;



public interface CenterRepository extends JpaRepository <Center, Integer>
{
	    Center findByName(String cname);
		Center findById(int id);
}
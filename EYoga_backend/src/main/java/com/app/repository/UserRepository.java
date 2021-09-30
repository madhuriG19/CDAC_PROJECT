package com.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.User;



public interface UserRepository extends JpaRepository <User, Integer>
{
	
	User findByName(String cname);
	User findById(int id);
}
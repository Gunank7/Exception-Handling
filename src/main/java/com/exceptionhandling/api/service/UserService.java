package com.exceptionhandling.api.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptionhandling.api.dto.UserRequest;
import com.exceptionhandling.api.entity.User;
import com.exceptionhandling.api.exception.UserNotFoundException;
import com.exceptionhandling.api.repository.UserRepository;

@Service
public  class UserService {
	
	@Autowired 
	private UserRepository repository;
	
	
	public User saveUser(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setAge(userRequest.getAge());
		user.setGender(userRequest.getGender());
		user.setMobile(userRequest.getMobile());
		user.setNationality(userRequest.getNationality());
		return repository.save(user);
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException {
		User user = repository.findByUserId(id);
		if(user!= null)
		{
			return user;
		}
		else
		{
			throw new UserNotFoundException("user not found with the id" +id);
		}
	}
}


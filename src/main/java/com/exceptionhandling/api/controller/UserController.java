package com.exceptionhandling.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionhandling.api.dto.UserRequest;
import com.exceptionhandling.api.entity.User;
import com.exceptionhandling.api.exception.UserNotFoundException;
import com.exceptionhandling.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<String> getAllUsers(){
		System.out.println("heklo");
		
		return ResponseEntity.ok("save");
	}
		
	@GetMapping("/{id}")	
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException
	{
		return ResponseEntity.ok(service.getUser(id));
	}

}

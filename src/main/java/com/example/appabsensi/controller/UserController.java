package com.example.appabsensi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.appabsensi.entity.UserTbl;
import com.example.appabsensi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<UserTbl> getAllUser(){
		return userService.findAllUser();
	}
	
	@PostMapping("/add")
	public UserTbl saveUser(@RequestBody UserTbl usertbl) {
		return userService.addUser(usertbl);
		
	}
	
	@GetMapping("/login/{username}&{password}")
	public UserTbl login(@PathVariable String username, @PathVariable String password) {
		
		
		return userService.getUserByNamePassword(username, password);
	}

}

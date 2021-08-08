package com.example.appabsensi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appabsensi.entity.UserTbl;
import com.example.appabsensi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<UserTbl> findAllUser(){
		return this.userRepo.findAll();
	}
	
	public UserTbl addUser(UserTbl usertbl) {
		return this.userRepo.save(usertbl);
		
	}
	
	public UserTbl getUserByNamePassword(String username, String password) {
		return this.userRepo.getNamePassword(username, password);
	}

}

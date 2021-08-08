package com.example.appabsensi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.appabsensi.entity.UserTbl;

public interface UserRepository extends JpaRepository<UserTbl, Long>{
	
	@Query(value="SELECT * FROM `usertbl` WHERE username = ?1 and password = ?2", nativeQuery = true)
	public UserTbl getNamePassword(String username, String password);

}

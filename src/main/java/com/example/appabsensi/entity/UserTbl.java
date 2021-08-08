package com.example.appabsensi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name = "usertbl")
	public class UserTbl {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String username;
		private String password;
		
//		@OneToMany(cascade = CascadeType.ALL)
//		@JoinColumn(name= "user_name", referencedColumnName = "username")
//		List<Absensi> absensi = new ArrayList<>();
}

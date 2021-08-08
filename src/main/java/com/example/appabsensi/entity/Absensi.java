package com.example.appabsensi.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="absensi")
public class Absensi {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long absensiId;
	private String photo;
	private String date;
	private String checkIn;
	private String checkOut;
	private String gpsLocation;
	private String username;

}
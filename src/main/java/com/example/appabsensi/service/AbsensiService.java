package com.example.appabsensi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appabsensi.entity.Absensi;
import com.example.appabsensi.repository.AbsensiRepository;

@Service
public class AbsensiService {
	
	@Autowired
	AbsensiRepository absensiRepo;
	
	public Absensi saveData(Absensi absensi) {
		return this.absensiRepo.save(absensi);
	}
	
	public List<Absensi> getHistoryByUsername(String username){
		return this.absensiRepo.getHistoryByUsername(username);
	}

}

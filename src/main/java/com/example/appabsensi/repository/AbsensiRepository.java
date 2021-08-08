package com.example.appabsensi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.appabsensi.entity.Absensi;

public interface AbsensiRepository extends JpaRepository<Absensi, Long> {
	
	@Query(value="SELECT * FROM absensi WHERE username = ?1", nativeQuery =true)
	public List<Absensi> getHistoryByUsername(String username);

}

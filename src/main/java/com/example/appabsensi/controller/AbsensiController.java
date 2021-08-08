package com.example.appabsensi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.example.appabsensi.entity.Absensi;
import com.example.appabsensi.service.AbsensiService;
import com.example.appabsensi.utils.FileUtility;
import com.google.gson.Gson;

@RestController
@RequestMapping("/absensi")
public class AbsensiController {
	
	@Autowired
	AbsensiService absensiService;
	
	@PostMapping("/add")
	public Absensi saveAbsen(@RequestParam(value = "file") MultipartFile images, 
			@ModelAttribute (value ="data") String dataJSON) throws IOException {
		
		String fileName = StringUtils.cleanPath(images.getOriginalFilename());
		String uploadDir = "src/main/java/absensi-photo/";
		FileUtility.saveFile(fileName, uploadDir, images);
		Absensi absensi = new Gson().fromJson(dataJSON, Absensi.class);
		absensi.setPhoto(fileName);
		return this.absensiService.saveData(absensi);
				
	}
	
	@GetMapping("/history/{username}")
	public List<Absensi> getHistory(@PathVariable String username){
		return this.absensiService.getHistoryByUsername(username);
	}

}

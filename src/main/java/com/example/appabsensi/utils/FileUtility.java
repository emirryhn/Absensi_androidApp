package com.example.appabsensi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.web.multipart.MultipartFile;

public class FileUtility {
	
	public static void saveFile(String fileName, String uploadDir, MultipartFile file) throws IOException {
		
		Path uploadPath = Paths.get(uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try (InputStream inputStream = file.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

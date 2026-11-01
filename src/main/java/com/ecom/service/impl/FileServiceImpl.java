package com.ecom.service.impl;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public boolean saveFile(MultipartFile file, Integer bucketType) {
		if (file == null || file.isEmpty()) {
			return true;
		}

		String subFolder = (bucketType == 1) ? "category_img" : (bucketType == 2) ? "product_img" : "profile_img";

		try {
			String filename = file.getOriginalFilename();
			String[] targetDirs = {
				"src/main/resources/static/img/" + subFolder,
				"target/classes/static/img/" + subFolder
			};

			byte[] bytes = file.getBytes();
			for (String dirPath : targetDirs) {
				File dir = new File(dirPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				Path destination = Paths.get(dir.getAbsolutePath(), filename);
				Files.write(destination, bytes);
			}

			return true;
		} catch (Exception e) {
			System.err.println("Notice: Failed to save file locally: " + e.getMessage());
			return false;
		}
	}

}

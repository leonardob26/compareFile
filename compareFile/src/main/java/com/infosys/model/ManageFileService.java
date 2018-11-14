package com.infosys.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
 
@Service
public class ManageFileService {
 
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path location = Paths.get("upload-dir");
 
	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.location.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
 
	public Resource loadFile(String filename) {
		try {
			Path file = location.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
 
	public String compare(String file1, String file2) throws IOException
    {    
		boolean areEqual = true;
		String result;
        BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		try {
			reader1 = new BufferedReader(new FileReader(location + "/" + file1));
			reader2 = new BufferedReader(new FileReader(location + "/"  + file2));			 
			String line1 = reader1.readLine();
			String line2 = reader2.readLine();
			 
			int lineNum = 1;
			while (line1 != null || line2 != null){
			    if(line1 == null || line2 == null){
			        areEqual = false;
			        break;
			    } else if(! line1.equalsIgnoreCase(line2)){
			        areEqual = false;
			        break;
			    }
			    line1 = reader1.readLine();
			    line2 = reader2.readLine();
			    lineNum++;
			}
			if(areEqual){
			    result = "Two files have same content.";
			} else {
				result = "Two files have different content. They differ at line "+lineNum;
			    result +="File1 has "+line1+" and File2 has "+line2+" at line "+lineNum;
			}
		} catch (IOException e) {
			result = "FAILED THE COMPARATION PROCESS";
		} finally {
	        reader1.close();
	        reader2.close();
		}
        return result;
    }
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(location.toFile());
	}
	public void init() {
		try {
			Files.createDirectory(location);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
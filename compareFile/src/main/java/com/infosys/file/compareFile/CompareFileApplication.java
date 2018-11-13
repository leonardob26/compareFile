package com.infosys.file.compareFile;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.infosys.model.ManageFileService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.infosys.controller", "com.infosys.model"})
public class CompareFileApplication implements CommandLineRunner{
	@Resource
	ManageFileService mfs;
	public static void main(String[] args) {
		SpringApplication.run(CompareFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mfs.deleteAll();
		mfs.init();
		
	}
}

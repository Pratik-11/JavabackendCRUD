package com.example.backendCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BackendCrudApplication implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(BackendCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.studentDao.insertData("pratik","dehradun");
		//this.studentDao.retrieveAllData();
		this.studentDao.updateData("pratik","dehradun","p","d");
		//this.studentDao.retrieveAllData();
	}

}

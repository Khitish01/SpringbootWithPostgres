package com.postgress.springwithpostgres;

import com.postgress.springwithpostgres.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringwithpostgressApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringwithpostgressApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//this.studentDao.updateData();
	}
}

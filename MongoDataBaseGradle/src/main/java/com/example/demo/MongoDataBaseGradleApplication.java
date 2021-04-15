package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class MongoDataBaseGradleApplication implements CommandLineRunner
{
	@Autowired
	StudentRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(MongoDataBaseGradleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student s=new Student(5,"Chenepalli","niktha","9876543210");
		Student s1=new Student(6,"Kavya","Sree","9876543210");
		repo.save(s);
		repo.save(s1);
		List<Student> list=repo.findAll();
		for(Student student:list)
		{
			System.out.println(student.toString());
		}
	}

}

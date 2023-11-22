package com.example.FirstProject;

import com.example.FirstProject.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstProjectApplication.class, args);
	}
//  Test vracemo
// Ova klasa treba da bude prazna
//	@GetMapping T
//	public List < String > getMessage(){
//		return List.of("FirstProject","Second","Third","Fourth","Fifth","Sixth");
//	}


}

package com.example.FirstProject.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return  args -> {

            Student Jovan = new Student(
                    "Jovan",
                    LocalDate.of(2001, Month.JANUARY,12)
                    ,"jovan@gmail.com");
            Student Ana = new Student(
                    "Ana",
                    LocalDate.of(2001,Month.JULY,12),
                    "ana@gmail.com");
            Student Marko = new Student(
                    "Marko",
                    LocalDate.of(2009,Month.FEBRUARY,12),
                    "marko@gmail.com");

            studentRepository.saveAll(
                    List.of(Jovan, Ana, Marko)
            );

        };
    }
}

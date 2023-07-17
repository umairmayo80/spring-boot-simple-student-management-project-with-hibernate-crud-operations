package com.example;
import com.example.domain.Student;
import com.example.respository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args ->{
            Student s1 = new Student("Ali","Ali@.com", LocalDate.parse("2001-01-01"));

            Student s2 = new Student("Umer","Umer@.com",LocalDate.parse("2005-01-01"));
            studentRepo.saveAll(List.of(s1,s2));
        };

    }
}

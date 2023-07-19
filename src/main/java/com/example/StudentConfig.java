package com.example;
import com.example.domain.Student;
import com.example.respository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;


/*
@Configuration Annotation:
The @Configuration annotation marks the class as a Spring configuration class. It tells Spring that this class provides bean definitions and configuration settings.

CommandLineRunner and @Bean:
The CommandLineRunner interface in Spring Boot allows you to execute code when the application starts up. It provides a single method run() that is called with the command-line arguments when the application is started.
* */

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args ->{
            Student s1 = new Student("Ali","Ali@.com", LocalDate.parse("2001-01-01"), 1000);

            Student s2 = new Student("Umer","Umer@.com",LocalDate.parse("2005-01-01"),1500);

            Student s3 = new Student("Khan","khan@.com",LocalDate.parse("2003-01-01"),3500);

            studentRepo.saveAll(List.of(s1,s2,s3));
        };

    }
}

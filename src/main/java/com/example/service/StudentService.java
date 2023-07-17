package com.example.service;

import com.example.domain.Student;
import com.example.respository.StudentRepo;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public void add(Student student) throws Exception {
        System.out.println(student);

        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new Exception("email taken");
        }
        System.out.println(studentOptional);

        studentRepo.save(student);
    }
}

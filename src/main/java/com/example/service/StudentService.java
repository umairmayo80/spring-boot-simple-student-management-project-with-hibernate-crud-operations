package com.example.service;

import com.example.domain.Student;
import com.example.respository.StudentRepo;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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



    public void delete(Long id) {
        System.out.println("student id:"+id);
        if(!studentRepo.existsById(id)){
            throw new IllegalStateException("student with id: '"+id+"' does not exist");
        }
        studentRepo.deleteById(id);

    }

    // @Transactional annotation put entity in manage state and then automatically commit or rollback
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepo.findById(studentId).
                orElseThrow(()-> new IllegalStateException("new IllegalStateException(\"student with id: '\"+id+\"' does not exist\");"));
        if(name !=null && name.length()>0){
            student.setName(name);
        }

        if(email !=null && email.length()>0){
            Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }


    public List<Student> getStudentByBillBetween(Long min, Long max){
        return studentRepo.findStudentByBillBetween(min,max);
    }
}

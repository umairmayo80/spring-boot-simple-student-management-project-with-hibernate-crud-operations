package com.example.respository;

import com.example.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {


//    @Query("Select s from Student s where s.email = ?1")  //optional
    Optional<Student> findStudentByEmail(String email);
//    List<Student> findStudentByDobBetween(LocalDate start, LocalDate end);

    List<Student> findStudentByBillBetween(Long minBill, Long maxBill);


}

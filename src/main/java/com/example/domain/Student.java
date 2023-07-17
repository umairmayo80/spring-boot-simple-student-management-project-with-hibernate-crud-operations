package com.example.domain;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name = "studentTable")
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student(Long id, String name, String email, LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Student() {
    }


    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        System.out.println("set dob called");
        this.dob = dob;
    }


    public void setAge(Integer age) {
        System.out.println("set age called");
        this.age = age;
    }

    public Integer getAge() {
        System.out.println("get age called");
        return Period.between(this.dob,LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }
}



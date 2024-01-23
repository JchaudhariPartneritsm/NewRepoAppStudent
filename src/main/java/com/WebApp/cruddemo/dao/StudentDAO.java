package com.WebApp.cruddemo.dao;

import com.WebApp.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findByID(Integer Id);

    List<Student> findAll();
}

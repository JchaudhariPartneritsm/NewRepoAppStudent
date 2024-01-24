package com.WebApp.cruddemo.dao;

import com.WebApp.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);//create

    Student findByID(Integer Id);//read by id

    List<Student> findAll();//read all

    List<Student> findByLastName(String theLastName);//read by lastname

    void update(Student theStudent);//update student

    void delete(Integer Id);//delete by id

    int deleteAll();//delete all
}

package org.example.ud_qlkh.service;

import org.example.ud_qlkh.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student customer);
    Student findById(int id);
    void update (int id, Student customer);
    void remove (int id);
}

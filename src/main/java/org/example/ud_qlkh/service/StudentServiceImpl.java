package org.example.ud_qlkh.service;

import org.example.ud_qlkh.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static Map<Integer, Student> studentMap;
    static {
        studentMap = new HashMap<>();
        studentMap.put(1, new Student(1,"Truong","Phan","1998-08-04","Quang Nam",8));
        studentMap.put(2, new Student(2,"Phuc","Tran","1998-08-04","Quang Nam",8));
        studentMap.put(3, new Student(3,"Loc","Phan","1998-08-04","Quang Nam",8));
        studentMap.put(4, new Student(4,"Tho","Phan","1998-08-04","Quang Nam",8));
        studentMap.put(5, new Student(5,"Phat","Phan","1998-08-04","Quang Nam",8));
        studentMap.put(6, new Student(6,"Tai","Phan","1998-08-04","Quang Nam",8));

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void save(Student customer) {
        studentMap.put(customer.getId(),customer);
    }

    @Override
    public Student findById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void update(int id, Student customer) {
        studentMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        studentMap.remove(id);
    }
}

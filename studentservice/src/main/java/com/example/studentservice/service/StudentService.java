package com.example.studentservice.service;


import com.example.studentservice.model.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);

    List<Student> readAllStudents();

    Student readStudent(int studentId);

    int readEstimate(int courseId, int studentId);

    List<Student> readStudentsInCourse(int courseId);

    boolean updateStudent(Student student, int studentId);

    boolean deleteStudent(int studentId);


}

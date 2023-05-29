package com.example.courseservice.service;

import com.example.courseservice.model.Course;
import com.example.courseservice.model.Lecturer;


import java.util.List;

public interface EducationService {
    void createLecturer(Lecturer lecturer);


    void createCourse(Course course);

    List<Lecturer> readAllLecturers();

    Lecturer readLecturer(int lecturerId);


    List<Course> readAllCourses();

    Course readCourse(int courseId);

    boolean updateLecturer(Lecturer lecturer, int lecturerId);

    boolean updateCourse(Course course, int courseId);

    boolean deleteLecturer(int lecturerId);

    boolean deleteCourse(int courseId);
}
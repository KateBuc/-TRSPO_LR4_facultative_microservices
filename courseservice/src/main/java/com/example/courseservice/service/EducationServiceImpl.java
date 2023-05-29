package com.example.courseservice.service;

import com.example.courseservice.model.Course;
import com.example.courseservice.model.Lecturer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EducationServiceImpl implements EducationService {


    private static final Map<Integer, Course> CLIENT_REPOSITORY_MAP = new HashMap<>();
    private static final Map<Integer, Lecturer> LECTURER_REPOSITORY_MAP = new HashMap<>();
    //private static final Map<Integer, Student> STUDENT_REPOSITORY_MAP = new HashMap<>();
    public static final Map<Integer, Course> COURSE_REPOSITORY_MAP = new HashMap<>();


    private static final AtomicInteger LECTURER_ID_HOLDER = new AtomicInteger();
    private static final AtomicInteger STUDENT_ID_HOLDER = new AtomicInteger();
    private static final AtomicInteger COURSE_ID_HOLDER = new AtomicInteger();

    @Override
    public void createLecturer(Lecturer lecturer) {
        final int lecturerId = LECTURER_ID_HOLDER.incrementAndGet();
        lecturer.setLecturerId(lecturerId);
        LECTURER_REPOSITORY_MAP.put(lecturerId, lecturer);
    }

    @Override
    public void createCourse(Course course) {
        final int courseId = COURSE_ID_HOLDER.incrementAndGet();
        course.setCourseId(courseId);
        COURSE_REPOSITORY_MAP.put(courseId, course);
    }

    @Override
    public List<Lecturer> readAllLecturers() {
        return new ArrayList<>(LECTURER_REPOSITORY_MAP.values());
    }

    @Override
    public Lecturer readLecturer(int lecturerId) {
        return LECTURER_REPOSITORY_MAP.get(lecturerId);
    }


    @Override
    public List<Course> readAllCourses() {
        return new ArrayList<>(COURSE_REPOSITORY_MAP.values());
    }

    @Override
    public Course readCourse(int courseId) {
        return COURSE_REPOSITORY_MAP.get(courseId);
    }

    @Override
    public boolean updateLecturer(Lecturer lecturer, int lecturerId) {
        if (LECTURER_REPOSITORY_MAP.containsKey(lecturerId)) {
            lecturer.setLecturerId(lecturerId);
            LECTURER_REPOSITORY_MAP.put(lecturerId, lecturer);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCourse(Course course, int courseId) {
        if (COURSE_REPOSITORY_MAP.containsKey(courseId)) {
            course.setCourseId(courseId);
            COURSE_REPOSITORY_MAP.put(courseId, course);

            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLecturer(int lecturerId) {
        return LECTURER_REPOSITORY_MAP.remove(lecturerId) != null;
    }

    @Override
    public boolean deleteCourse(int courseId) {
        return COURSE_REPOSITORY_MAP.remove(courseId) != null;
    }


}
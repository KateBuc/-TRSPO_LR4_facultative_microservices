package com.example.studentservice.service;

import com.example.studentservice.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class StudentServiceImpl implements StudentService{

    private static final Map<Integer, Student> STUDENT_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger STUDENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void createStudent(Student student) {
        final int studentId = STUDENT_ID_HOLDER.incrementAndGet();
        student.setStudentId(studentId);

        STUDENT_REPOSITORY_MAP.put(studentId, student);
    }

    @Override
    public List<Student> readAllStudents() {
        return new ArrayList<>(STUDENT_REPOSITORY_MAP.values());
    }

    @Override
    public Student readStudent(int studentId) {
        return STUDENT_REPOSITORY_MAP.get(studentId);
    }

    @Override
    public int readEstimate(int courseId, int studentId) {
        int[][] studentEstimates = com.example.courseservice.service.EducationServiceImpl.COURSE_REPOSITORY_MAP.get(courseId).getStudentEstimates();
        return studentEstimates[studentId-1][1];
    }

    @Override
    public List<Student> readStudentsInCourse(int courseId) {
        List studentList = new ArrayList();
        int[][] studentEstimates = com.example.courseservice.service.EducationServiceImpl.COURSE_REPOSITORY_MAP.get(courseId).getStudentEstimates();
        for(int i=0;i<studentEstimates.length;i++){
            studentList.add(STUDENT_REPOSITORY_MAP.get(studentEstimates[i][0]));
        }

        return studentList;

    }

    @Override
    public boolean updateStudent(Student student, int studentId) {
        if (STUDENT_REPOSITORY_MAP.containsKey(studentId)) {
            student.setStudentId(studentId);
            STUDENT_REPOSITORY_MAP.put(studentId, student);
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteStudent(int studentId) {
        return STUDENT_REPOSITORY_MAP.remove(studentId) != null;
    }

}
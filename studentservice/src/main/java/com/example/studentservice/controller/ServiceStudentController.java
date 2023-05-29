package com.example.studentservice.controller;


import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceStudentController {



    private final StudentService studentService;
    @Autowired
    public ServiceStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //post


    @PostMapping(value = "/student")
    public ResponseEntity<?> create(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




    //get



    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> readStudents() {
        final List<Student> students = studentService.readAllStudents();

        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/students/{studentId}")
    public ResponseEntity<Student> readStudents(@PathVariable(name = "studentId") int studentId) {
        final Student student = studentService.readStudent(studentId);

        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }






    @GetMapping(value = "/courses/{courseId}/students/{studentId}/estimate")
    public ResponseEntity<Integer> readEstimate(@PathVariable(name = "courseId") int courseId,@PathVariable(name = "studentId") int studentId) {
        final Integer estimate = studentService.readEstimate(courseId,studentId);

        return estimate != null
                ? new ResponseEntity<>(estimate, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/courses/{courseId}/students")
    public ResponseEntity<List<Student>> readStudentsInCourse(@PathVariable(name = "courseId") int courseId) {
        final List<Student> students = studentService.readStudentsInCourse(courseId);

        return students != null
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //put



    @PutMapping(value = "/students/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "studentId") int studentId, @RequestBody Student student) {
        final boolean updated = studentService.updateStudent(student, studentId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



    //delete



    @DeleteMapping(value = "/students/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "studentId") int studentId) {
        final boolean deleted = studentService.deleteStudent(studentId);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

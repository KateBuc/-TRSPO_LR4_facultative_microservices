package com.example.courseservice.controller;

import com.example.courseservice.model.Course;
import com.example.courseservice.model.Lecturer;
import com.example.courseservice.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {


    private final EducationService educationService;
    @Autowired
    public ServiceController(EducationService educationService) {
        this.educationService = educationService;
    }

    //post

    @PostMapping(value = "/lecturer")
    public ResponseEntity<?> create(@RequestBody Lecturer lecturer) {
        educationService.createLecturer(lecturer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping(value = "/course")
    public ResponseEntity<?> create(@RequestBody Course course) {
        educationService.createCourse(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //get

    @GetMapping(value = "/lecturers")
    public ResponseEntity<List<Lecturer>> readLecturers() {
        final List<Lecturer> lecturers = educationService.readAllLecturers();

        return lecturers != null && !lecturers.isEmpty()
                ? new ResponseEntity<>(lecturers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/lecturers/{lecturerId}")
    public ResponseEntity<Lecturer> readLecturers(@PathVariable(name = "lecturerId") int lecturerId) {
        final Lecturer lecturer = educationService.readLecturer(lecturerId);

        return lecturer != null
                ? new ResponseEntity<>(lecturer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> readCourses() {
        final List<Course> courses = educationService.readAllCourses();

        return courses != null && !courses.isEmpty()
                ? new ResponseEntity<>(courses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/courses/{courseId}")
    public ResponseEntity<Course> readCourses(@PathVariable(name = "courseId") int courseId) {
        final Course course = educationService.readCourse(courseId);

        return course != null
                ? new ResponseEntity<>(course, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //put

    @PutMapping(value = "/lecturers/{lecturerId}")
    public ResponseEntity<?> updateLecturer(@PathVariable(name = "lecturerId") int lecturerId, @RequestBody Lecturer lecturer) {
        final boolean updated = educationService.updateLecturer(lecturer, lecturerId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/courses/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable(name = "courseId") int courseId, @RequestBody Course course) {
        final boolean updated = educationService.updateCourse(course, courseId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //delete

    @DeleteMapping(value = "/lecturers/{lecturerId}")
    public ResponseEntity<?> deleteLecturer(@PathVariable(name = "lecturerId") int lecturerId) {
        final boolean deleted = educationService.deleteLecturer(lecturerId);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
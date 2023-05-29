package com.example.courseservice.model;

public class Course {
    private Integer courseId;
    private String name;
    private Integer lecturerId;
    private Integer durationMonths;

    //[0]-studentId,[1]-estimate
    int[][] archive = new int[6][2];

    public int[][] getStudentEstimates() {
        return archive;
    }

    public void setStudentEstimates(int[][] studentEstimates) {
        this.archive = studentEstimates;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }


    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }
}

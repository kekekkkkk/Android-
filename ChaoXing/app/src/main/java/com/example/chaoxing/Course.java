package com.example.chaoxing;

public class Course {
    private int imageCourse;
    private String title;
    private String lecturer;

    public Course(int imageCourse, String title, String lecturer) {
        this.imageCourse = imageCourse;
        this.title = title;
        this.lecturer = lecturer;
    }

    public int getImageCourse() {
        return imageCourse;
    }

    public String getTitle() {
        return title;
    }

    public String getLecturer() {
        return lecturer;
    }
}
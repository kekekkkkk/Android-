package com.example.course;

public class Course {
    private int imageCurld;
    private String title;
    private String lecturer;

    public Course(int imageCurld, String title, String lecturer) {
        this.imageCurld = imageCurld;
        this.title = title;
        this.lecturer = lecturer;
    }

    public int getImageCurld() {
        return imageCurld;
    }

    public String getTitle() {
        return title;
    }

    public String getLecturer() {
        return lecturer;
    }
}

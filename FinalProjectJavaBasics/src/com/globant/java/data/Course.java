package com.globant.java.data;

import java.util.List;

public class Course {
    private String courseName;
    private int classroom;
    private List<Student> courseStudentList;
    private Teacher teacher;
    private static int nextId = 1;
    private final int classId;

    public Course(String courseName, int classroom, List<Student> courseStudentList, Teacher teacher) {
        this.courseName = courseName;
        this.classroom = classroom;
        this.courseStudentList = courseStudentList;
        this.teacher = teacher;
        classId = nextId;
        nextId++;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }
    public void setCourseStudentList(List<Student> courseStudentList) {
        this.courseStudentList = courseStudentList;
    }

    public int getClassroom() {
        return classroom;
    }
    public List<Student> getCourseStudentList() {
        return courseStudentList;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public String getCourseName() {
        return courseName;
    }

    // Generate course id that increment automatically one by one
    public int generateCourseId() {
        return classId;
    }

    public void addNewStudentToCourseStudentList(Student student) {
        courseStudentList.add(student);
    }

    public String toString(){
        return "Course Name: " + getCourseName() + "\n"
                + "Class ID: " + generateCourseId() + "\n"
                + "Classroom: " + getClassroom() + "\n"
                + "* Students Data: " + "\n" + getCourseStudentList() + "\n"
                + "* Teacher Data: " + "\n" + getTeacher()
                + "----------------------";
    }
}

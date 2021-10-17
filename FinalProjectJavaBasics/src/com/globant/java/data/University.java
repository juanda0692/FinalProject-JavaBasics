package com.globant.java.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> studentsList;
    private List<Teacher> teachersList;
    private List <Course> coursesList;

    // Constructor
    public University() {
        this.studentsList = new ArrayList<>();
        this.teachersList = new ArrayList<>();
        this.coursesList = new ArrayList<>();
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
    public List<Teacher> getTeachersList() {
        return teachersList;
    }
    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void addStudent (Student student) {
        studentsList.add(student);
    }
    public void addTeacher (Teacher teacher) {
        teachersList.add(teacher);
    }
    public void addCourse (Course course) {
        coursesList.add(course);
    }

    public void addNewStudentToCourse(Student student, int i) {
        coursesList.get(i).addNewStudentToCourseStudentList(student);
    }
}



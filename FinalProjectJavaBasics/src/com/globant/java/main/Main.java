package com.globant.java.main;


import com.globant.java.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optionMenu;
        int optionSubMenu;
        University hogwarts = new University();

        List<Student> newCourseStudentsList = new ArrayList<>();

        List<Student> studentsListCourse1 = new ArrayList<>();
        List<Student> studentsListCourse2 = new ArrayList<>();
        List<Student> studentsListCourse3 = new ArrayList<>();
        List<Student> studentsListCourse4 = new ArrayList<>();

        Student student1 = new Student("Thomas Hobbes", 35);
        Student student2 = new Student ("Jose Saramago", 19);
        Student student3 = new Student ("Lou Andreas Salome", 48);
        Student student4 = new Student ("Fedor Dostoievski", 73);
        Student student5 = new Student ("Alan Moore", 81);
        Student student6 = new Student ("Simone de Beauvoir", 30);
        Student student7 = new Student ("Haruki Murakami", 42);
        Student student8 = new Student ("Chuck Palahniuk", 24);

        hogwarts.addStudent(student1);
        hogwarts.addStudent(student2);
        hogwarts.addStudent(student3);
        hogwarts.addStudent(student4);
        hogwarts.addStudent(student5);
        hogwarts.addStudent(student6);
        hogwarts.addStudent(student7);
        hogwarts.addStudent(student8);

        studentsListCourse1.add(student1);
        studentsListCourse1.add(student5);
        studentsListCourse1.add(student7);
        studentsListCourse1.add(student2);
        studentsListCourse2.add(student3);
        studentsListCourse2.add(student4);
        studentsListCourse2.add(student1);
        studentsListCourse2.add(student8);
        studentsListCourse3.add(student6);
        studentsListCourse3.add(student4);
        studentsListCourse3.add(student2);
        studentsListCourse3.add(student7);
        studentsListCourse4.add(student6);
        studentsListCourse4.add(student2);
        studentsListCourse4.add(student3);
        studentsListCourse4.add(student5);

        Teacher teacherFullTime1 = new FullTimeTeacher("Walter White", 915.50f, 9f);
        Teacher teacherFullTime2 = new FullTimeTeacher("Albus Dumbledore", 915.50f, 20.5f);
        Teacher teacherFullTime3 = new FullTimeTeacher("Edna Krabappel", 915.50f, 16f);
        Teacher teacherPartTime1 = new PartTimeTeacher("Kesuke Miyagi", 640.75f, 7.5f);
        Teacher teacherPartTime2 = new PartTimeTeacher("Marguerite Yourcenar", 640.75f, 7.5f);
        Teacher teacherPartTime3 = new PartTimeTeacher("Friedrich Nietzsche", 640.75f, 7.5f);

        hogwarts.addTeacher(teacherFullTime1);
        hogwarts.addTeacher(teacherFullTime2);
        hogwarts.addTeacher(teacherFullTime3);
        hogwarts.addTeacher(teacherPartTime1);
        hogwarts.addTeacher(teacherPartTime2);
        hogwarts.addTeacher(teacherPartTime3);

        Course course1 = new Course("Chemistry advanced", 309, studentsListCourse1, hogwarts.getTeachersList().get(0));
        Course course2 = new Course("Defence against the dark arts", 212, studentsListCourse2, hogwarts.getTeachersList().get(1));
        Course course3 = new Course("Basic arithmetic", 136, studentsListCourse3, hogwarts.getTeachersList().get(2));
        Course course4 = new Course("Karate fundamentals", 430, studentsListCourse4, hogwarts.getTeachersList().get(3));

        hogwarts.addCourse(course1);
        hogwarts.addCourse(course2);
        hogwarts.addCourse(course3);
        hogwarts.addCourse(course4);

        do {
            System.out.println("\n ** ¡Welcome to Hogwarts University! ** \n" + "\n" +
                    "Menu: \n" +
                    "1. Print teachers information \n" +
                    "2. Print the courses information \n" +
                    "3. Create a new student and add it to a course \n" +
                    "4. Create a new course with students and teacher \n" +
                    "5. Search a student's courses  \n" +
                    "6. Exit \n" +
                    "--------------------------------------");
            System.out.println("Select an option: ");
            optionMenu = scanner.nextInt();
            switch (optionMenu) {
                case 1:
                    System.out.println("\n" + "* The following is the staff of our teachers: " + "\n");
                    for (Teacher teacher: hogwarts.getTeachersList()) {
                    System.out.println(teacher);
                }
                    break;
                case 2:
                    System.out.println("\n" + "* The following is the list of our current courses: " + "\n");
                    for (int i = 0; i < hogwarts.getCoursesList().size(); i++) {
                            System.out.println("Course #" + (i+1) + "\n" + "Name: " + hogwarts.getCoursesList().get(i).getCourseName() + "\n");
                        }
                    System.out.println("* Select the course's information that you want to see: ");
                    optionSubMenu = scanner.nextInt();
                    if (optionSubMenu > 0 && optionSubMenu <= hogwarts.getCoursesList().size()) {
                        for (Course course: hogwarts.getCoursesList()) {
                            if (optionSubMenu == course.generateCourseId()) {
                                System.out.println(course);
                            }
                        }
                    } else {
                        System.out.println("Select a valid option!");
                    }
                    break;
                case 3:
                    System.out.println("\n" + "* Create a new student *" + "\n");
                    System.out.println("Type the name of the new student: ");
                    scanner = new Scanner(System.in);
                    String newStudentName = scanner.nextLine();
                    System.out.println("Type the age of the new student: ");
                    scanner = new Scanner(System.in);
                    int newStudentAge = scanner.nextInt();
                    System.out.println("Type the number of the course where you want to add the student: ");
                    for (Course course: hogwarts.getCoursesList()) {
                        System.out.println("Course #" + (course.generateCourseId()) + "\n" + "Name: " + course.getCourseName());
                    }
                    scanner = new Scanner(System.in);
                    int i = scanner.nextInt() - 1;
                    Student newStudent = new Student(newStudentName, newStudentAge);
                    newStudent.setName(newStudentName);
                    newStudent.setAge(newStudentAge);
                    hogwarts.addStudent(newStudent);
                    hogwarts.addNewStudentToCourse(newStudent, i);
                    System.out.println("The following is the course's list of students updated: \n");
                    for (int j = 0; j < hogwarts.getCoursesList().get(i).getCourseStudentList().size(); j++) {
                        System.out.println(hogwarts.getCoursesList().get(i).getCourseStudentList().get(j));
                    }
                    break;
                case 4:
                    System.out.println("\n" + "* Create a new course *" + "\n");
                    System.out.println("Type the name of the new course: ");
                    scanner = new Scanner(System.in);
                    String newCourseName = scanner.nextLine();
                    System.out.println("Type the classroom's number of the new course: ");
                    scanner = new Scanner(System.in);
                    int newClassroom = scanner.nextInt();
                    System.out.println("\n" + "* The following is the list of our students: " + "\n");
                    for (Student student: hogwarts.getStudentsList()) {
                        System.out.println("Student ID: " + student.generateId() + "\n" + "Name: " + student.getName() + "\n");
                    }
                    System.out.println("Type the student's ID you would like to add: ");
                    int studentId = scanner.nextInt();
                    for(int j = 0; j < hogwarts.getStudentsList().size(); j++){
                        if(studentId == hogwarts.getStudentsList().get(j).generateId()){
                            newCourseStudentsList.add(hogwarts.getStudentsList().get(j));
                        }
                    }
                    int addStudentOption;
                    do {
                        System.out.println("\n" + "Do you want to add another student?" +
                                "\n" + "1. Yes" +
                                "\n" + "2. No");
                        scanner = new Scanner(System.in);
                        addStudentOption = scanner.nextInt();
                            if (addStudentOption == 1) {
                                System.out.println("\n" + "* The following is the list of our students: " + "\n");
                                for (Student student: hogwarts.getStudentsList()) {
                                    System.out.println("Student ID: " + student.generateId() + "\n" + "Name: " + student.getName() + "\n");
                                }
                                System.out.println("Type the student's ID you would like to add: ");
                                studentId = scanner.nextInt();
                                for(int j = 0; j < hogwarts.getStudentsList().size(); j++){
                                    if(studentId == hogwarts.getStudentsList().get(j).generateId()){
                                        newCourseStudentsList.add(hogwarts.getStudentsList().get(j));
                                    }
                                }
                            } else if (addStudentOption <= 0 || addStudentOption >= 3) {
                                System.out.println("\n" + "Type a valid option");
                            }
                    } while (addStudentOption != 2);

                    System.out.println("\n" + "Type the kind of teacher that you want to add :" +
                            "\n" + "1. Full time" +
                            "\n" + "2. Part time");
                    scanner = new Scanner(System.in);
                    int newKindOfTeacher = scanner.nextInt();
                    System.out.println("Type the name of the new teacher: " );
                    scanner = new Scanner(System.in);
                    String newTeacherName = scanner.nextLine();
                    System.out.println("Type the base salary of the new teacher: ");
                    scanner = new Scanner(System.in);
                    float newTeacherSalaryBase = scanner.nextFloat();

                    Teacher newTeacher = new FullTimeTeacher(newTeacherName, newTeacherSalaryBase, 0);
                    if (newKindOfTeacher == 1) {
                        System.out.println("Type the experience years of the new teacher: ");
                        scanner = new Scanner(System.in);
                        float newTeacherExpYears = scanner.nextFloat();
                        newTeacher = new FullTimeTeacher(newTeacherName, newTeacherSalaryBase, newTeacherExpYears);
                    } else if (newKindOfTeacher == 2) {
                        System.out.println("Type the hours per week that will work the new teacher: ");
                        scanner = new Scanner(System.in);
                        float newTeacherHoursPerWeek = scanner.nextFloat();
                        newTeacher = new PartTimeTeacher(newTeacherName, newTeacherSalaryBase, newTeacherHoursPerWeek);

                    } else {
                        System.out.println("\n" + "Type a valid option");
                    }

                    newTeacher.setName(newTeacherName);
                    newTeacher.setSalaryBase(newTeacherSalaryBase);
                    hogwarts.getTeachersList().add(newTeacher);

                    Course newCourse = new Course(newCourseName, newClassroom, newCourseStudentsList, newTeacher);
                    newCourse.setCourseName(newCourseName);
                    newCourse.setClassroom(newClassroom);
                    newCourse.setCourseStudentList(newCourseStudentsList);
                    newCourse.setTeacher(newTeacher);
                    hogwarts.getCoursesList().add(newCourse);

                    System.out.println("\n" + "* Very good. Your course has been successfully created. The following is the new course information: " + "\n");
                    System.out.println(hogwarts.getCoursesList().get(hogwarts.getCoursesList().size()-1));
                    break;
                case 5:
                    System.out.println("\n" + "* The following is the list of our students: " + "\n");
                    for (Student student: hogwarts.getStudentsList()) {
                        System.out.println("Student ID: " + student.generateId() + "\n" + "Name: " + student.getName() + "\n");
                    }
                    System.out.println("Type the student's ID to see the courses that attend: ");
                    scanner = new Scanner(System.in);
                    studentId = scanner.nextInt();

                    if (studentId > 0 && studentId <= hogwarts.getStudentsList().size()) {
                        System.out.println("\n" + "* The following are the courses that the student attend: ");
                        for (Course course: hogwarts.getCoursesList()){
                            for (Student student: course.getCourseStudentList()){
                                if(studentId == student.generateId()){
                                    System.out.println("Course name: " + course.getCourseName());
                                }
                            }
                        }
                    } else {
                        System.out.println("\n" + "Select a valid option!");
                    }
                    break;
                case 6:
                    System.out.println("\n" + "* Thank you for use the service hogwarts enrollment, see you later!");
                    break;
                default:
                    System.out.println("\n" + "Option not valid, type another option");
                    break;
            }
        } while (optionMenu != 6);

    }
}

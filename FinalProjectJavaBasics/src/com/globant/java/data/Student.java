package com.globant.java.data;

public class Student extends Person {
    private final int id;
    private static int nextId = 1;
    private int age;

    // Constructor
    public Student(String name, int age) {
        // Attribute inherit by the superclass
        super(name);
        this.age = age;
        id = nextId;
        nextId++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    // Generate student id that increment automatically one by one
    public int generateId() {
        return id;
    }

    @Override
    public String toString(){
        return "name: " + getName() + "\n"
                + "age: " + getAge() + "\n"
                + "Student id: " + generateId() + "\n"
                + "----------------------";
    }
}

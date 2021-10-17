package com.globant.java.data;

public abstract class Person {
    protected String name;

    // Constructor
   public Person(String name) {
        this.name = name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

    public abstract String toString();
}

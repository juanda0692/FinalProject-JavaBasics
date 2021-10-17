package com.globant.java.data;

public class PartTimeTeacher extends Teacher {
    private float hoursPerWeek;

    public PartTimeTeacher(String name, float salaryBase, float hoursPerWeek){
        super(name, salaryBase);
        this.hoursPerWeek = hoursPerWeek;
    }

    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    @Override
    public float getSalary(){
        return getSalaryBase() * getHoursPerWeek();
    }
}

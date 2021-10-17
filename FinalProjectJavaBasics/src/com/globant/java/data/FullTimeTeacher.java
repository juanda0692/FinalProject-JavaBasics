package com.globant.java.data;

public class FullTimeTeacher extends Teacher {
    private float experienceYears;

    public FullTimeTeacher(String name, float salaryBase, float experienceYears){
        super(name, salaryBase);
        this.experienceYears = experienceYears;
    }

    public float getExperienceYears() {
        return experienceYears;
    }

    // Method to obtain 110% of its experience years
    public float multipliedPercentByExperienceYears(){
        return 1.1f * getExperienceYears();
    }

    @Override
    public float getSalary(){
        return getSalaryBase() * multipliedPercentByExperienceYears();
    }
}

package com.globant.java.data;

public abstract class Teacher extends Person {
    protected float salaryBase;

    public Teacher(String name, float salaryBase) {
        super(name);
        this.salaryBase = salaryBase;
    }

    public void setSalaryBase(float salaryBase) {
        this.salaryBase = salaryBase;
    }

    public float getSalaryBase() {
        return salaryBase;
    }

    @Override
    public String toString(){
        return "name: " + getName() + "\n"
                + "salary: " + getSalary() + "\n"
                + "----------------------";
    }

    public abstract float getSalary();
}



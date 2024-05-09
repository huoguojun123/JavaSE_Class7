package com.example.model;

public class RegularEmployee extends Employee{

    public RegularEmployee(int employeeId, String name, int age, char gender, double salary, Department department, Position position) {
        super(employeeId, name, age, gender, salary, department, position);
    }

    @Override
    public void promote() {
        System.out.println("Promoting Regular Employee");
    }

    @Override
    public void train() {
        System.out.println("Training for Regular Employee");
    }
}

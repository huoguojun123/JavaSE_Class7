package com.example.model;

// 职员信息抽象类
public abstract class Employee {
    private int employeeId;
    private String name;
    private int age;
    private char gender;
    private double salary;
    private Department department;
    private Position position;

    public Employee(int employeeId, String name, int age, char gender, double salary, Department department, Position position) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    // 抽象类的用于控制不同种类员工的晋升和培训方法
    public abstract void promote();
    public abstract void train();
    
}

package com.example.model;

import java.util.List;

// 职员的职位信息类
public class Position {

    private String title;
    
    // 使用泛型List
    private List<Employee> employees;

    public Position(String title, List<Employee> employees) {
        this.title = title;
        this.employees = employees;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

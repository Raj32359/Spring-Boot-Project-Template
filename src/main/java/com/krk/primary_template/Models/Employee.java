package com.krk.primary_template.Models;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Employee {

    private UUID serialId;

    private String email;

    private String name;

    private int age;

    private long salary;

    public UUID getSerialId() {
        return serialId;
    }

    public void setSerialId(UUID serialId) {
        this.serialId = serialId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(UUID serialId, String email, String name, int age, long salary) {
        this.serialId = serialId;
        this.email = email;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

}

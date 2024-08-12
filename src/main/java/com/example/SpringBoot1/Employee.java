package com.example.SpringBoot1;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long empid;
    @Column
    private String name;
    @Column
    private double salary;
    @Column
    private String skill;
    
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Employee(long empid, String name, double salary, String skill) {
        super();
        this.empid = empid;
        this.name = name;
        this.salary = salary;
        this.skill = skill;
    }
    public long getEmpid() {
        return empid;
    }
    public void setEmpid(long empid) {
        this.empid = empid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
}
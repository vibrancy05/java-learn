package EmployeeSystem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private String id;
    private String name;
    private String gender;
    private int age;
    private String department;
    private String phone;
    private String salary;

    public Employee(String id, String name, String gender, int age,
                    String department, String phone, String salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.phone = phone;
        this.salary = salary;
    }

    // Getter和Setter方法
    public String getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public String getPhone() { return phone; }
    public String getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAge(int age) { this.age = age; }
    public void setDepartment(String department) { this.department = department; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setSalary(String salary) { this.salary = salary; }
}
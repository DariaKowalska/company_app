package pl.java.companyApp.company;

import javax.xml.bind.annotation.XmlAttribute;

public class Employee {
    private int id;
    private String name;
    private String lastName;
    private double salary;
    private String email;

    private Employee() {}

    public Employee(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee(String name, String lastName, double salary, String email) {
        this(name, lastName, salary);
        this.email = email;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %.2f, %s\n", id, name, lastName, salary, email);
    }
}

package pl.java.companyApp.company;

import java.util.Arrays;

public class Company {
    private static final int MAX_EMPLOYEES_COUNT = 20;
    private String name;
    private Employee[] employees;
    private int numberOfEmployees;

    public Company(String name) {
        this.name = name;
        this.employees = new Employee[MAX_EMPLOYEES_COUNT];
        numberOfEmployees = 0;
    }

    public Employee[] getEmployees() {
        return Arrays.copyOf(employees, numberOfEmployees);
    }

    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Pracownik nie moze byc nullem");
        }
        if (numberOfEmployees == MAX_EMPLOYEES_COUNT) {
            return false;
        }
        employees[numberOfEmployees++] = employee;
        return true;

        ///////////////////////////////////////////////////
        //    if (liczbaPracownikow < MAX_EMPLOYEES_COUNT) {
        //      pracownicy[liczbaPracownikow++] = pracownik;
        //      return true;
        //    }
        //    return false;
    }

    public boolean deleteEmployee(Employee employee) {
        // todo: implement this
        return false;
    }

    public boolean deleteEmployee(int id) {
        return false;
    }
}

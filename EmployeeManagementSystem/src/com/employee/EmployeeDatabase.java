package com.employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {
    private List<Employee> employees = new ArrayList<>();
    private final String filePath = "employees.txt";

    public EmployeeDatabase() { loadEmployees(); }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployees();
    }

    public void updateEmployee(int id, String newName, String newDepartment) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, new Employee(newName, id, newDepartment));
                saveEmployees();
                break;
            }
        }
    }

    public List<Employee> getEmployees() { return employees; }

    private void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee emp : employees) {
                writer.write(emp.getId() + "," + emp.getName() + "," + emp.getDepartment());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String department = parts[2];
                    employees.add(new Employee(name, id, department));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
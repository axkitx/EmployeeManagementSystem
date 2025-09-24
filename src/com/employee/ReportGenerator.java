package com.employee;

import java.util.List;

public class ReportGenerator {
    public String generateReport(List<Employee> employees) {
        StringBuilder report = new StringBuilder("Employee Report:\n");
        for (Employee emp : employees) {
            report.append(emp).append("\n");
        }
        return report.toString();
    }
}
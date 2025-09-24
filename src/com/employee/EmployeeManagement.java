package com.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagement extends JFrame {
    private EmployeeDatabase database = new EmployeeDatabase();
    private JTextArea reportArea;
    private JTextField nameField, idField, departmentField;

    public EmployeeManagement() {
        setTitle("Employee Management System");
        setSize(800, 500);
        setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        inputPanel.add(departmentField);

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new AddEmployeeAction());
        inputPanel.add(addButton);

        JButton updateButton = new JButton("Update Employee");
        updateButton.addActionListener(new UpdateEmployeeAction());
        inputPanel.add(updateButton);

        add(inputPanel, BorderLayout.NORTH);

        // Report Area
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setLineWrap(true);
        reportArea.setWrapStyleWord(true);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        // Button to generate report
        JButton reportButton = new JButton("Generate Report");
        reportButton.addActionListener(new GenerateReportAction());
        add(reportButton, BorderLayout.SOUTH);
    }

    private class AddEmployeeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            String department = departmentField.getText();
            database.addEmployee(new Employee(name, id, department));
            JOptionPane.showMessageDialog(null, "Employee added successfully.");
            clearFields();
        }
    }

    private class UpdateEmployeeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(idField.getText());
            String newName = nameField.getText();
            String newDepartment = departmentField.getText();
            database.updateEmployee(id, newName, newDepartment);
            JOptionPane.showMessageDialog(null, "Employee updated successfully.");
            clearFields();
        }
    }

    private class GenerateReportAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ReportGenerator reportGenerator = new ReportGenerator();
            String report = reportGenerator.generateReport(database.getEmployees());
            reportArea.setText(report);
        }
    }

    private void clearFields() {
        nameField.setText("");
        idField.setText("");
        departmentField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagement frame = new EmployeeManagement();
            frame.setVisible(true);
        });
    }
}
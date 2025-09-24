# Employee Management System

A simple **Java-based Employee Management System** to manage employee records, generate reports, and store data in a text file.

## 📂 Project Structure
```
EmployeeManagementSystem/
 ├── employees.txt              # Stores employee records
 ├── src/com/employee/
 │   ├── Employee.java          # Model class for employee
 │   ├── EmployeeDatabase.java  # Handles employee storage and retrieval
 │   ├── EmployeeManagement.java# Main class with menu-driven program
 │   └── ReportGenerator.java   # Generates employee reports
```

## 🚀 Features
- Add new employees  
- View employee details  
- Update employee records  
- Delete employee records  
- Generate reports  
- Store data persistently in `employees.txt`

## 🛠️ Technologies Used
- **Java (JDK 8+)**  
- **File Handling** for persistent storage  

## ▶️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/EmployeeManagementSystem.git
   ```
2. Navigate to the project directory:
   ```bash
   cd EmployeeManagementSystem/EmployeeManagementSystem/src
   ```
3. Compile the project:
   ```bash
   javac com/employee/*.java
   ```
4. Run the program:
   ```bash
   java com.employee.EmployeeManagement
   ```

## 📖 Example
```
===== Employee Management System =====
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Generate Report
6. Exit
Enter your choice:
```

## 📌 Future Enhancements
- Switch to database (MySQL/SQLite) instead of text file  
- Add GUI (JavaFX / Swing)  
- Export reports in PDF/Excel  

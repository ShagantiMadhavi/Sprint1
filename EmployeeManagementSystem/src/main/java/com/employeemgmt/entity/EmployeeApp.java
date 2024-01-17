package com.employeemgmt.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Main.java
public class EmployeeApp {
 public static void main(String[] args) {
     SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
     EmployeeDAO employeeDAO = new EmployeeDAO(sessionFactory);
     DepartmentDAO departmentDAO = new DepartmentDAO(sessionFactory);

     // Create and save a department
     Department department1 = new Department();
     department1.setName("IT Department");
     departmentDAO.saveDepartment(department1);
     // Create and save an employee associated with the department
     Employee employee1 = new Employee();
     employee1.setName("Hrithik");
     employee1.setDesignation("Software Engineer");
     employee1.setSalary(50000.0);
     employee1.setDepartment(department1);
     employeeDAO.saveEmployee(employee1);
     
     
     
     Department department2 = new Department();
     department2.setName("Accounting Department");
     departmentDAO.saveDepartment(department2);
     // Create and save an employee associated with the department
     Employee employee2 = new Employee();
     employee2.setName("Roshan");
     employee2.setDesignation("Accountant");
     employee2.setSalary(10000.0);
     employee2.setDepartment(department2);
     employeeDAO.saveEmployee(employee2);
     
     
     
     
     Department department3 = new Department();
     department3.setName("Teaching Department");
     departmentDAO.saveDepartment(department3);
     // Create and save an employee associated with the department
     Employee employee3 = new Employee();
     employee3.setName("Rahul Kumar");
     employee3.setDesignation("Faculty");
     employee3.setSalary(30000.0);
     employee3.setDepartment(department3);
     employeeDAO.saveEmployee(employee3);
     
     
     
     Department department4 = new Department();
     department4.setName("Electrical Department");
     departmentDAO.saveDepartment(department4);
     // Create and save an employee associated with the department
     Employee employee4 = new Employee();
     employee4.setName("Neetu Singh");
     employee4.setDesignation("Testing Engineer");
     employee4.setSalary(40000.0);
     employee4.setDepartment(department4);
     employeeDAO.saveEmployee(employee4);
     
     
     
     Department department5 = new Department();
     department5.setName("Mechanical Department");
     departmentDAO.saveDepartment(department5);
     // Create and save an employee associated with the department
     Employee employee5 = new Employee();
     employee5.setName("Karan Johar");
     employee5.setDesignation("Architect");
     employee5.setSalary(50000.0);
     employee5.setDepartment(department5);
     employeeDAO.saveEmployee(employee5);
     
     
     Department department6 = new Department();
     department6.setName("Training Department");
     departmentDAO.saveDepartment(department6);
     // Create and save an employee associated with the department
     Employee employee6 = new Employee();
     employee6.setName("Vijay");
     employee6.setDesignation("Trainer");
     employee6.setSalary(50000.0);
     employee6.setDepartment(department6);
     employeeDAO.saveEmployee(employee6);
     Department department7 = new Department();
     department7.setName("Library Department");
     departmentDAO.saveDepartment(department7);

     // Create and save an employee associated with the department
     Employee employee7 = new Employee();
     employee7.setName("Anu Bhatt");
     employee7.setDesignation("Secretary");
     employee7.setSalary(50000.0);
     employee7.setDepartment(department7);
     employeeDAO.saveEmployee(employee7);
     
     
     
     
     // Retrieve and display employee with associated department
     Employee retrievedEmployee = employeeDAO.getEmployeeById(1);
     System.out.println("Retrieved Employee: " + retrievedEmployee.getName());
     System.out.println("Employee Department: " + retrievedEmployee.getDepartment().getName());

     // Update employee details
     retrievedEmployee.setSalary(60000.0);
     employeeDAO.updateEmployee(retrievedEmployee);

     // Delete employee
     //employeeDAO.deleteEmployee(retrievedEmployee);

     // Clean up resources
     sessionFactory.close();
 }
}


//public class EmployeeApp {
//
//    public static void main(String[] args) {
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        // CRUD Operations
//        // Create and save an employee
//        Employee newEmployee1 = new Employee(1, "Hrithik", "Roshan", "Male", "hrithik.roshan@example.com", 1234567890);
//        Employee newEmployee2 = new Employee(2, "Alia", "Bhatt", "Female", "alia.bhatt@example.com", 1234567891);
//        Employee newEmployee3 = new Employee(3, "Varun", "Dhawan", "Male", "varun.dhawan@example.com", 1234567892);
//        Employee newEmployee4 = new Employee(4, "Deepika", "Padukone", "Female", "deepika.padukone@example.com", 1234567893);
//        Employee newEmployee5 = new Employee(5, "Karthik", "Aryan","Male", "karthik.aryan@example.com", 1234567894);
//        Employee newEmployee6 = new Employee(6, "Shahrukh", "Khan","Male", "shahrukh.khan@example.com", 1234567895);
//        Employee newEmployee7 = new Employee(7, "Salman", "Khan","Male", "salman.khan@example.com", 1234567896);
//        Employee newEmployee8 = new Employee(8, "Sidharth", "Malhotra","Male", "sidharth.malhotra@example.com", 1234567897);
//
//        employeeDAO.saveEmployee(newEmployee1);
//        employeeDAO.saveEmployee(newEmployee2);
//        employeeDAO.saveEmployee(newEmployee3);
//        employeeDAO.saveEmployee(newEmployee4);
//        employeeDAO.saveEmployee(newEmployee5);
//        employeeDAO.saveEmployee(newEmployee6);
//        employeeDAO.saveEmployee(newEmployee7);
//        employeeDAO.saveEmployee(newEmployee8);
//
//        // Fetch and display all employees
//        System.out.println("All Employees: ");
//        employeeDAO.getAllEmployees().forEach(System.out::println);
//
//        // Update an employee
//        Employee employeeToUpdate = employeeDAO.getEmployeeById(2);
//        if (employeeToUpdate != null) {
//            employeeToUpdate.setEmpFirstName("Nisha");
//            employeeDAO.updateEmployee(employeeToUpdate);
//        }
//
//        // Fetch and display all employees after update
//        System.out.println("All Employees after update: ");
//        employeeDAO.getAllEmployees().forEach(System.out::println);
//
//        // Delete an employee
//        employeeDAO.deleteEmployee(8);
//        // Fetch and display all employees after delete
//        System.out.println("All Employees after delete: ");
//        employeeDAO.getAllEmployees().forEach(System.out::println);
//
//        // Close EntityManagerFactory
//        employeeDAO.closeEntityManagerFactory();
//    }
//}

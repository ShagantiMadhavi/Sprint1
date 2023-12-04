package com.hibernate.project;



public class EmployeeApp {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        // CRUD Operations: Create, Read, Update, Delete
        // Create and save an employee
        Employee newEmployee1 = new Employee(1, "Hrithik", "Roshan", "Male", "hrithik.roshan@example.com", 1234567890);
        Employee newEmployee2 = new Employee(2, "Alia", "Bhatt", "Female", "alia.bhatt@example.com", 1234567891);
        Employee newEmployee3 = new Employee(3, "Varun", "Dhawan", "Male", "varun.dhawan@example.com", 1234567892);
        Employee newEmployee4 = new Employee(4, "Deepika", "Padukone", "Female", "deepika.padukone@example.com", 1234567893);
        Employee newEmployee5 = new Employee(5, "Karthik", "Aryan","Male", "karthik.aryan@example.com", 1234567894);
        Employee newEmployee6 = new Employee(6, "Shahrukh", "Khan","Male", "shahrukh.khan@example.com", 1234567895);
        Employee newEmployee7 = new Employee(7, "Salman", "Khan","Male", "salman.khan@example.com", 1234567896);
        Employee newEmployee8 = new Employee(8, "Sidharth", "Malhotra","Male", "sidharth.malhotra@example.com", 1234567897);

        employeeDAO.saveEmployee(newEmployee1);
        employeeDAO.saveEmployee(newEmployee2);
        employeeDAO.saveEmployee(newEmployee3);
        employeeDAO.saveEmployee(newEmployee4);
        employeeDAO.saveEmployee(newEmployee5);
        employeeDAO.saveEmployee(newEmployee6);
        employeeDAO.saveEmployee(newEmployee7);
        employeeDAO.saveEmployee(newEmployee8);

        // Fetch and display all employees
        System.out.println("All Employees: ");
        employeeDAO.getAllEmployees().forEach(System.out::println);

        // Update an employee
        Employee employeeToUpdate = employeeDAO.getEmployeeById(2);
        if (employeeToUpdate != null) {
            employeeToUpdate.setEmpFirstName("Nisha");
            employeeDAO.updateEmployee(employeeToUpdate);
        }

        // Fetch and display all employees after update
        System.out.println("All Employees after update: ");
        employeeDAO.getAllEmployees().forEach(System.out::println);

        // Delete an employee
        employeeDAO.deleteEmployee(6);
        // Fetch and display all employees after delete
        System.out.println("All Employees after delete: ");
        employeeDAO.getAllEmployees().forEach(System.out::println);

        // Close EntityManagerFactory
        employeeDAO.closeEntityManagerFactory();
    }
}

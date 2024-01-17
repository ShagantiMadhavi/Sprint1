package com.employeemgmt.entity;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String designation;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	public Employee(int id, String name, String designation, double salary, Department department) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.department = department;
	}

	public Employee() {
	}

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", department=" + department + "]";
	}

//	mysql> CREATE TABLE department (
//		        id INT PRIMARY KEY AUTO_INCREMENT,
//		         name VARCHAR(255)
//		     );
//		Query OK, 0 rows affected (0.02 sec)
//
//		mysql> -- Create a table for the Employee entity
//		mysql> CREATE TABLE employee (
//		        id INT PRIMARY KEY AUTO_INCREMENT,
//		         name VARCHAR(255),
//		         designation VARCHAR(255),
//		         salary DOUBLE,
//		         department_id INT,
//		         CONSTRAINT fk_department
//		             FOREIGN KEY (department_id)
//		             REFERENCES department(id)
//		     );
//		Query OK, 0 rows affected (0.05 sec)
}
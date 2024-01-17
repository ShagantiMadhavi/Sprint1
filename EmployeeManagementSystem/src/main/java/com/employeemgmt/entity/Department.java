package com.employeemgmt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employee;


	public Department(int id, String name, List<Employee> employee) {
		this.id = id;
		this.name = name;
		this.employee = employee;
	}


	public Department() {
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


	public List<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(List<Employee> employee) {
	    this.employee = employee;
	}



	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employee + "]";
	}
    
    

    // Getters and Setters
}
package com.java.cs.model;

import java.util.Objects;

public class Employees {

	private int employee_id ;
	private String name ;
	private String department ;
	private String email  ;
	private String password;
	
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employees [employee_id=" + employee_id + ", name=" + name + ", department=" + department + ", email="
				+ email + ", password=" + password + "]";
	}
	
	public Employees() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Employees(int employee_id, String name, String department, String email, String password) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(department, email, employee_id, name, password);
	}
	@Override
	public boolean equals(Object obj) {
		
		Employees employees = (Employees) obj;
		if(employees.getEmployee_id()==employee_id
				&& employees.getName()==name
				&& employees.getDepartment()==department
				&&employees.getEmail()==email
				&&employees.getPassword()==password) {
			return true;
		}
		return false;
			
	}
	
	
	
	
}

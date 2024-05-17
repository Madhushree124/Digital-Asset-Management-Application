package com.java.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cs.model.Employees;
import com.java.cs.util.DBConnUtil;
import com.java.cs.util.DBPropertyUtil;




public class EmployeesDaoImpl implements EmployeesDao{

	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Employees> showEmployeesDao() throws ClassNotFoundException, SQLException {
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd = "select * from employees";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employees> employeesList = new ArrayList<Employees>();
		Employees employees = null;

		while(rs.next()) {
			employees=new Employees();
			employees.setEmployee_id(rs.getInt("employee_id"));
			employees.setName(rs.getString("name"));
			employees.setDepartment(rs.getString("department"));
			employees.setEmail(rs.getString("email"));
			employees.setPassword(rs.getString("password"));
			employeesList.add(employees);
		}

		return employeesList;
		
		
	}
	@Override
	public String addEmployees(Employees employees) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String pwd=EncryptPassword.getCode(employees.getPassword());
		employees.setPassword(pwd);
		String cmd="Insert into employees (employee_id,name,department,email,password) "
				+ "values(?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, employees.getEmployee_id());
		pst.setString(2, employees.getName());
		pst.setString(3,employees.getDepartment());
		pst.setString(4, employees.getEmail());
		pst.setString(5, employees.getPassword());
		pst.executeUpdate();
		SendMail.mailSend("madhushreethangavel@gmail.com", "My First Java Mail", "Hexaware Training");
		return "employees Record Inserted...";
	}
	@Override
	public Employees searchEmployees(int employee_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connStr=DBPropertyUtil.connectionString("db");
		connection=DBConnUtil.getConnection(connStr);
		String cmd="Select * from employees where employee_id=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, employee_id);
		ResultSet rs=pst.executeQuery();
		Employees employees=null;
		if(rs.next()) {
			employees=new Employees();
			employees.setEmployee_id(rs.getInt("employee_id"));
			employees.setName(rs.getString("name"));
			employees.setDepartment(rs.getString("department"));
			employees.setEmail(rs.getString("email"));
			employees.setPassword(rs.getString("password"));
			
		}
		return employees;
	}
	@Override
	public String updateEmployees(Employees employees) throws ClassNotFoundException, SQLException {
		Employees employeesfound=searchEmployees(employees.getEmployee_id());
		if(employeesfound!=null) {
			String connStr=DBPropertyUtil.connectionString("db");
			connection=DBConnUtil.getConnection(connStr);
			String cmd="update employees set name=?,department=?,email=?,password=? where employee_id=?";
			pst=connection.prepareStatement(cmd);
			pst.setString(1, employees.getName());
			pst.setString(2, employees.getDepartment());
			pst.setString(3, employees.getEmail());
			pst.setString(4, employees.getPassword());
			pst.setInt(5, employees.getEmployee_id());
			pst.executeUpdate();
			return "Record updated";
			
			
		}
		return "Record not updated";
	}
}

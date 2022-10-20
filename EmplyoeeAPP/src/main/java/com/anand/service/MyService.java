package com.anand.service;

import java.util.List;

import com.anand.model.Employee;

public interface MyService {
	
	public Employee saveEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public Employee getEmployee(Integer empId);
    public List<Employee> getAllEmployee();
    public void deleteEmployee(Integer id);

}

package com.anand.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.model.Employee;
import com.anand.service.MyService;

@RestController
public class MyController
{

	
  @Autowired
  private MyService ser;
	
  
	@PostMapping(value="/save")
	public Employee saveEmployeee(@RequestBody Employee obj )
	{
	  Employee emp2=ser.saveEmployee(obj);
	  String s=null;
		 if(emp2!=null)
		 {
			 s=" employee added";
		 }
		 else
		 {
			 s=" employee not added";
		 }
		 System.out.println(s);
	  return emp2;
	}
	
	@GetMapping("/get/{empId}")
	public Employee getEmployeee(@PathVariable Integer empId)
	{
		Employee emps=ser.getEmployee(empId);
		Employee empMdl=new Employee();
		if(emps!=null)
		{
		    BeanUtils.copyProperties(emps,empMdl);
		}
		return empMdl;
	}
	
	@PutMapping(value="/update/{empId}")
	public Employee updateEmployeee(@RequestBody Employee empmdl,@PathVariable Integer empId)
	{
		Employee response=ser.getEmployee(empId);
		Employee emp=new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empmdl.getEmpName());
		emp.setSalary(empmdl.getSalary());
		Employee emp3=ser.updateEmployee(emp);
		return emp3;
		
	}
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees()
	{
		List<Employee> empList=ser.getAllEmployee();
		List<Employee> empRes=new ArrayList<Employee>();
		
		for(Employee entity:empList)
		{
			Employee emp=new Employee();
			if(entity!=null)
			{
				BeanUtils.copyProperties(entity,emp);
				empRes.add(emp);
			}
		}
		return empRes;
		
	}
	
	@DeleteMapping("/delete/{empId}")
	public void deleteEmployeeById(@PathVariable Integer empId)
	{
		 ser.deleteEmployee(empId);
	}

}
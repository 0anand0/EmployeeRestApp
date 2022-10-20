package com.anand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.model.Employee;
import com.anand.repo.MyRepo;


@Service
public class MyServiceImp implements MyService{
  
	 @Autowired
	private MyRepo repoo;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		 Employee emp1=repoo.save(emp);
		
		return emp1;
	
	}

	@Override
	public Employee updateEmployee(Employee emp1) {
		Employee emp2=repoo.save(emp1);
		return emp2;
			}

	@Override
	public Employee getEmployee(Integer empId) {
		Optional<Employee> empres=repoo.findById(empId);
		Employee res=empres.get();
		return res;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empres=repoo.findAll();
		return empres;
		

	
	}

	@Override
	public void deleteEmployee(Integer id) {
		
		repoo.deleteById(id);
		
		
	}


}

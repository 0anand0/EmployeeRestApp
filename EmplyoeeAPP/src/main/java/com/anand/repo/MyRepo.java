package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.anand.model.Employee;
@Repository
public interface MyRepo extends JpaRepository<Employee, Integer> {

}

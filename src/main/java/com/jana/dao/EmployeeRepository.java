package com.jana.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jana.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//add a method to sort by lastName
	public List<Employee> findAllByOrderByLastNameAsc();

}

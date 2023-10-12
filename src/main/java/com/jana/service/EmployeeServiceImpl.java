package com.jana.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.dao.EmployeeRepository;
import com.jana.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepo;
	
	

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
		
		employeeRepo = theEmployeeRepo;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return employeeRepo.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result=employeeRepo.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("Did not find the Employee ID: "+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepo.save(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(theId);
		
	}

}

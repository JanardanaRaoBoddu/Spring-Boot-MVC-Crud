package com.jana.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jana.entity.Employee;
import com.jana.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	/*
	 * private List<Employee> theEmployees;
	 * 
	 * 
	 * @PostConstruct private void loadData() {
	 * 
	 * theEmployees=Arrays.asList(new Employee("Janardan", "Boddu",
	 * "janardanaraoboddu@gmail.com"), new Employee("Prasad", "Seepana",
	 * "prasadseepana@gmail.com"), new Employee("saikiran", "thota",
	 * "saikiranthota@gmail.com"));
	 * 
	 * }
	 */
	
	private EmployeeService empService;
	public EmployeeController(EmployeeService theEmpService) {
		empService=theEmpService;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int theId) {
		empService.deleteById(theId);
		return "redirect:/employees/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int theId,Model model) {
		
		//get the employee from the service
		Employee theEmployee=empService.findById(theId);
		
		//set employee as a model attribute to pre-populate form
		model.addAttribute("employee",theEmployee);
		
		//send over to our form
		return "employees/employeeForm";
		
	}
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employees form database
		List<Employee> theEmployees=empService.findAll();

		theModel.addAttribute("employees", theEmployees);

		return "employees/listOfEmployees";

	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee theEmployee=new Employee();
		model.addAttribute("employee",theEmployee);
		return "employees/employeeForm";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee theEmployee) {
		//save the employee
		empService.save(theEmployee);
		
		//use redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
}

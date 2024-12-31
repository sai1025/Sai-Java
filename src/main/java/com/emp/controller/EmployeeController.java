package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.emp.repository.EmployeeRepository;
import com.emp.service.CloudImageService;

import jakarta.servlet.http.HttpSession;

import com.emp.dto.EmployeeDTO;
import com.emp.dto.LoginDTO;
import com.emp.entities.Employee;
import com.emp.helper.Message;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	 private final EmployeeRepository employeeRepository;
	 private final CloudImageService cloudImageService;

	 	public EmployeeController(EmployeeRepository employeeRepository,CloudImageService cloudImageService) {
	        this.employeeRepository = employeeRepository;
			this.cloudImageService = cloudImageService;
	       
	    }
	
	@PostMapping("/authenticate")
	public String login(@ModelAttribute LoginDTO loginDto,Model model,HttpSession session) {
		
		System.out.println(loginDto);
		
		Optional<Employee> empByEmail = employeeRepository.findByEmail(loginDto.getEmail());
		
		if(empByEmail.isPresent())
		{
			Employee employee = empByEmail.get();
			
			if(employee.getPassword().equals(loginDto.getPassword()))
			{
				
				return "redirect:/employee/"+employee.getId();
			}
			else
				session.setAttribute("message",new Message("enter correct password!","alert-danger"));
			
		}
		else
			session.setAttribute("message",new Message("enter correct email id!","alert-danger"));
		
		
		return "redirect:/home";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute Employee employee,@RequestParam("profile_picture") MultipartFile file,HttpSession session)
	{
		System.out.println(employee);
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		String uploadImageURL = cloudImageService.uploadImage(file);
		employee.setImageUrl(uploadImageURL);
		
		Employee save = employeeRepository.save(employee);
		
		if(save!=null) {
			session.setAttribute("message",new Message("employee registered successfully!","alert-success"));
			return "home";
		}
		else {
			session.setAttribute("message",new Message("employee registered successfully!","alert-danger"));
			
		return "signup";
		}
	}

	@GetMapping("/{id}")
	public String getEmployee(@PathVariable Integer id,Model model)
	{
		 Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee employee = optionalEmployee.get();
	            List<String>departmentList=List.of("HR","IT","SALES");
	            model.addAttribute("employee",employee);
				model.addAttribute("departmentList", departmentList);
				return "view_employee";
	        }
	    //employee is registered,redirect to home
		return "redirect:/home";
	}
	 @GetMapping("/department/{department}")
	 @ResponseBody
	 public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
	        return employeeRepository.findByDepartment(department);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO,Model model) {
	 
		 System.out.println(employeeDTO);
		 System.out.println(id);
		 
		 Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee employee = optionalEmployee.get();
	            
	            employee.setPhone(employeeDTO.getPhone());
	            employee.setAddress(employeeDTO.getAddress());
	            employee.setDepartment(employeeDTO.getDepartment());
	            Employee saved = employeeRepository.save(employee);
	            
	           
				model.addAttribute("employee", saved);
				return ResponseEntity.ok(saved);

	        } else {
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	       
			
		 
	 }
	 
	 
}

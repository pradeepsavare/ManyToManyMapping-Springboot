package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class ManyToManyMappingApplication  implements CommandLineRunner {
	

	
	@Autowired
	private EmployeeRepository empRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMappingApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Employee emp1 = new Employee();
		emp1.setName("Raju");
		emp1.setEmail("raju@gmail.com");
		
		Department dep1 = new Department();
		dep1.setDepname("IT");
		
		Department dep2 = new Department();
		dep2.setDepname("HR");
		
		emp1.getDepatrments().add(dep1);
		emp1.getDepatrments().add(dep2);
		
		dep1.getEmployees().add(emp1);
		dep2.getEmployees().add(emp1);
		
		
		
		Employee emp2 = new Employee();
		emp2.setName("pinki");
		emp2.setEmail("pinki@gmail.com");
		
		emp2.getDepatrments().add(dep1);
		dep1.getEmployees().add(emp2);
		empRepo.save(emp1);
		empRepo.save(emp2);
		
	}

}

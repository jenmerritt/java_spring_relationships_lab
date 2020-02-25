package com.codeclan.example.relationshipslab;

import com.codeclan.example.relationshipslab.models.Department;
import com.codeclan.example.relationshipslab.models.Employee;
import com.codeclan.example.relationshipslab.models.Project;
import com.codeclan.example.relationshipslab.repositories.DepartmentRepository;
import com.codeclan.example.relationshipslab.repositories.EmployeeRepository;
import com.codeclan.example.relationshipslab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelationshipslabApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateEmployeeAndDepartment(){
		Department sales = new Department("Sales");
		departmentRepository.save(sales);

		Employee john = new Employee("John", "Smith", 123, sales);
		employeeRepository.save(john);
	}

	@Test
	public void canCreateProject(){
		Project java = new Project("Java", 21);
		projectRepository.save(java);
	}

	@Test
	public void canAddProjectToEmployee(){
		Department accounts = new Department("Accounts");
		departmentRepository.save(accounts);

		Employee jane = new Employee("Jane", "Doe", 456, accounts);

		Project ruby = new Project("Ruby", 15);
		projectRepository.save(ruby);

		jane.getProjects().add(ruby);
		employeeRepository.save(jane);
	}

	@Test
	public void canAddEmployeeToProject(){
		Department marketing = new Department("Marketing");
		departmentRepository.save(marketing);

		Employee bob = new Employee("Bob", "Jones", 789, marketing);
		employeeRepository.save(bob);

		Project javascript = new Project("JavaScript", 20);
		javascript.getEmployees().add(bob);

		projectRepository.save(javascript);
	}
}

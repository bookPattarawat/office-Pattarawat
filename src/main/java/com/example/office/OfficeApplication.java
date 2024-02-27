package com.example.office;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.office.model.Department;
import com.example.office.model.Employee;
import com.example.office.model.Project;
import com.example.office.repository.DepartmentRepository;
import com.example.office.repository.EmployeeRepository;
import com.example.office.repository.ProjectRepository;


@SpringBootApplication
public class OfficeApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(
			OfficeApplication.class);
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ProjectRepository projectRepository;

	public OfficeApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, ProjectRepository projectRepository) {

		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.projectRepository = projectRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// throw new UnsupportedOperationException("Unimplemented method 'run'");

		Department department1 = new Department("A101");
		Department department2 = new Department("A202");
		Project project1 = new Project("Project101");
		Project project2 = new Project("Project202");

		departmentRepository.saveAll(Arrays.asList(department1,department2));
		projectRepository.saveAll(Arrays.asList(project1,project2));

		employeeRepository.save(new Employee("Kittipan", 3500, department1, project1));
		employeeRepository.save(new Employee("Phommithat", 3000, department2, project2));

		// Fetch all cars and log to console
		for (Employee employee : employeeRepository.findAll()) {
			logger.info("Name: {}, Salary: {}", 
					employee.getName(), employee.getSalary());
		}

		logger.info("-------- Department ---------");
		for (Department department : departmentRepository.findAll()) {
			logger.info("Department: {}",
				department.getName());
		}

		logger.info("-------- Project ---------");
		for (Project project : projectRepository.findAll()) {
			logger.info("Project: {}",
					project.getName());
		}
	}
}
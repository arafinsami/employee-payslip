package com.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = "com.employee.entity")
public class EmployeeApp {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApp.class, args);
	}

	@Bean
	CommandLineRunner runner(EmployeeService employeeService) {
		return args -> {
			List<Employee> employees = new ArrayList<>();
			Employee employee1 = new Employee();
			employee1.setFirstName("David");
			employee1.setLastName("Rudd");
			employee1.setAnnualSalary(60050);
			employee1.setSuperRate(0.09);
			employee1.setPaymentMonth("01 March - 31 March");

			Employee employee2 = new Employee();
			employee2.setFirstName("Ryan");
			employee2.setLastName("Chen");
			employee2.setAnnualSalary(120000);
			employee2.setSuperRate(0.1);
			employee2.setPaymentMonth("01 March - 31 March");

			employees.add(employee1);
			employees.add(employee2);
			employeeService.saveAll(employees);
		};
	}
}

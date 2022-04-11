package com.employee.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.entity.Employee;
import com.employee.request.EmployeePaySlipRequest;
import com.employee.request.EmployeeRequest;
import com.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.employee.utils.CollectionUtils.nullSafe;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeHelper {

	private final EmployeeService employeeService;

	public List<Employee> getEmployees(EmployeePaySlipRequest request) {
		List<Employee> employees = new ArrayList<Employee>();
		List<EmployeeRequest> employeeRequests = request.getEmployees();
		employeeRequests.forEach(dto -> {
			List<Employee> results = employeeService.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
			employees.addAll(results);
		});
		log.info("all employee lists from helper {} ", employees);
		return nullSafe(employees);
	}
}

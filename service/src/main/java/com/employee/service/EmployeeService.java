package com.employee.service;

import static com.employee.utils.CollectionUtils.nullSafe;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
		List<Employee> employees = nullSafe(employeeRepository.findByFirstNameAndLastName(firstName, lastName));
		log.info("all employee lists from service {} ", employees);
		return employees;
	}

	@Transactional
	public List<Employee> saveAll(List<Employee> employees) {
		List<Employee> lists = employeeRepository.saveAll(employees);
		log.info("saving employee lists from service {} ", employees);
		return lists;
	}

}

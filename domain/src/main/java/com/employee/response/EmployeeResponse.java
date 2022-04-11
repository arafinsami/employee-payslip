package com.employee.response;

import com.employee.entity.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeResponse {

	private String firstName;

	private String lastName;

	private Integer annualSalary;

	private Double superRate;

	private String paymentMonth;

	public static EmployeeResponse select(Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		response.setFirstName(employee.getFirstName());
		response.setLastName(employee.getLastName());
		response.setAnnualSalary(employee.getAnnualSalary());
		response.setSuperRate(employee.getSuperRate());
		response.setPaymentMonth(employee.getPaymentMonth());
		return response;
	}

}

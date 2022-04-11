package com.employee.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeRequest {

	private String firstName;

	private String lastName;

	private Integer annualSalary;

	private Double superRate;

	private String paymentMonth;

}

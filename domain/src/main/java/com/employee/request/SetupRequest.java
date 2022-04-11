package com.employee.request;

import java.io.Serializable;

import com.employee.entity.Employee;
import com.poiji.annotation.ExcelCellName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SetupRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExcelCellName("First Name")
	private String firstName;

	@ExcelCellName("Last Name")
	private String lastName;

	@ExcelCellName("Annual Salary")
	private String annualSalary;

	@ExcelCellName("Super Rate")
	private String superRate;

	@ExcelCellName("Payment Month")
	private String paymentMonth;

	public Employee toImportData() {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setAnnualSalary(Integer.parseInt(annualSalary));
		employee.setSuperRate(Double.parseDouble(superRate));
		employee.setPaymentMonth(paymentMonth);
		return employee;
	}
}

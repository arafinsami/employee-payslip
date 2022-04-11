package com.employee.response;

import static com.employee.utils.PaySlipUtils.employeeGrossIncome;
import static com.employee.utils.PaySlipUtils.employeeIncomeTax;
import static com.employee.utils.PaySlipUtils.employeeNetIncome;
import static com.employee.utils.PaySlipUtils.employeeSuperAnnuation;
import static com.employee.utils.StringUtils.trim;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeePaySlipResponse {

	private EmployeeResponse employee;

	private String fromDate;

	private String toDate;

	private float grossIncome;

	private double incomeTax;

	private double superannuation;

	private double netIncome;

	public static EmployeePaySlipResponse select(EmployeeResponse employeeResponse) {
		EmployeePaySlipResponse response = new EmployeePaySlipResponse();
		response.setEmployee(employeeResponse);
		response.setFromDate(trim(employeeResponse.getPaymentMonth().split("-")[0]));
		response.setToDate(trim(employeeResponse.getPaymentMonth().split("-")[1]));
		response.setGrossIncome(employeeGrossIncome(employeeResponse.getAnnualSalary()));
		response.setIncomeTax(employeeIncomeTax(employeeResponse.getAnnualSalary()));
		response.setSuperannuation(employeeSuperAnnuation(employeeResponse.getAnnualSalary(), employeeResponse.getSuperRate()));
		response.setNetIncome(employeeNetIncome(employeeResponse.getAnnualSalary()));
		return response;
	}
}

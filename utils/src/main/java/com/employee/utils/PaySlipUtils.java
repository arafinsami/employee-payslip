package com.employee.utils;

import static com.employee.utils.StringUtils.isNotEmpty;

public class PaySlipUtils {

	public static long employeeIncomeTax(Integer annualSalary) {
		long incomeTax = 0;
		if (isNotEmpty(annualSalary)) {
			if (annualSalary >= 0 && annualSalary <= 18200) {
				incomeTax = 0;
			} else if (annualSalary >= 18201 && annualSalary <= 37000) {
				incomeTax = Math.round((0 + (annualSalary - 18200) * 0.19) / 12);
			} else if (annualSalary >= 37001 && annualSalary <= 87000) {
				incomeTax = Math.round((3572 + (annualSalary - 37000) * 0.325) / 12);
			} else if (annualSalary >= 87001 && annualSalary <= 180000) {
				incomeTax = Math.round((19822 + (annualSalary - 87000) * 0.37) / 12);
			} else if (annualSalary >= 180001) {
				incomeTax = Math.round((54232 + (annualSalary - 180000) * 0.45) / 12);
			}
		}
		return incomeTax;
	}

	public static long employeeNetIncome(Integer annualSalary) {
		if (isNotEmpty(annualSalary))
			return employeeGrossIncome(annualSalary) - employeeIncomeTax(annualSalary);
		return 0;
	}

	public static double employeeSuperAnnuation(Integer annualSalary, Double superRate) {
		if (isNotEmpty(annualSalary) && isNotEmpty(superRate))
			return Math.round(employeeGrossIncome(annualSalary) * superRate);
		return 0;
	}

	public static int employeeGrossIncome(Integer annualSalary) {
		if (isNotEmpty(annualSalary))
			return Math.round(annualSalary / 12);
		return 0;
	}

}

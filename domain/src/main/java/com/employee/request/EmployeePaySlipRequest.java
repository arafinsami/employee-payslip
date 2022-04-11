package com.employee.request;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeePaySlipRequest {

	private List<EmployeeRequest> employees;
}

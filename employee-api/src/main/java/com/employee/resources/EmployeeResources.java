package com.employee.resources;

import static com.employee.utils.CollectionUtils.nullSafe;
import static com.employee.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.entity.Employee;
import com.employee.helper.EmployeeHelper;
import com.employee.request.EmployeePaySlipRequest;
import com.employee.request.SetupRequest;
import com.employee.response.EmployeePaySlipResponse;
import com.employee.response.EmployeeResponse;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "employee")
@Tag(name = "Employee Pay Slip API")
public class EmployeeResources {

	private final EmployeeHelper employeeHelper;

	@PostMapping("/payslip")
	@Operation(summary = "show lists of employee", description = "lists of employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "found employee", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmployeePaySlipRequest.class))) }) })
	public ResponseEntity<JSONObject> findAll(@RequestBody EmployeePaySlipRequest request) {

		List<Employee> employees = employeeHelper.getEmployees(request);

		List<EmployeeResponse> responses = nullSafe(employees).stream()
				.map(EmployeeResponse::select)
				.collect(Collectors.toList());

		List<EmployeePaySlipResponse> paySlipResponses = nullSafe(responses).stream()
				.map(EmployeePaySlipResponse::select)
				.collect(Collectors.toList());
		log.info("all employee lists {} ", paySlipResponses);
		return ok(success(nullSafe(paySlipResponses), "employee payslip found with given info").getJson());
	}

	@PostMapping(value = "/upload-payslip", consumes = { "multipart/form-data" })
	@Operation(summary = "upload lists of employee payslip", description = "upload lists of employee payslip")
	public ResponseEntity<?> uploadPayslip(@RequestPart("file") MultipartFile file) throws IOException {

		String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

		List<SetupRequest> items = Poiji.fromExcel(file.getInputStream(),
				PoijiExcelType.valueOf(extension.toUpperCase()), SetupRequest.class,
				PoijiOptions.PoijiOptionsBuilder.settings().preferNullOverDefault(true).build());

		List<Employee> employees = items.stream()
				.map(SetupRequest::toImportData)
				.collect(Collectors.toList());

		employeeHelper.uploadPayslip(employees);
		return ResponseEntity.ok("employee pay slip uploaded");
	}

}

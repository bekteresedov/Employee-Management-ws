package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.data.dto.request.EmployeeCreate;
import com.employee.data.dto.request.EmployeeUpdate;
import com.employee.data.dto.response.EmployeeResponse;
import com.employee.service.EmployeeService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class EmployeeController {

	final  EmployeeService employeeService;

	@GetMapping("/all")

	public List<EmployeeResponse> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/new")

	public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeCreate newEmployeeCreate) {
		return employeeService.createEmployee(newEmployeeCreate);
	}

	@GetMapping("/find/{id}")
	@PreAuthorize("hasRole('user')")
	public EmployeeResponse getOneEmployee(@PathVariable Long id) {
		return employeeService.findEmployee(id);
	}

	@PutMapping("/update/{id}")

	public EmployeeResponse updateEmployeeAll(@PathVariable Long id,
			@Valid @RequestBody EmployeeUpdate newEmployeeUpdate) {
		return employeeService.updateEmployeeAll(id, newEmployeeUpdate);
	}

	@DeleteMapping("/delete/{id}")

	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}

}

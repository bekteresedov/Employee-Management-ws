package com.employee.service;

import java.util.List;


import com.employee.data.dto.request.EmployeeCreate;
import com.employee.data.dto.request.EmployeeUpdate;
import com.employee.data.dto.response.EmployeeResponse;

public interface EmployeeService {

	List<EmployeeResponse> getAllEmployees();

	EmployeeResponse createEmployee(EmployeeCreate newCEmployeeCreate);

	EmployeeResponse findEmployee(Long id);

	EmployeeResponse updateEmployeeAll(Long id, EmployeeUpdate newEmployeeUpdate);
	
	void deleteEmployee(Long id);

}

package com.employee.data.dto.convert;

import com.employee.data.dto.request.EmployeeCreate;
import com.employee.data.dto.request.EmployeeUpdate;
import com.employee.data.dto.response.EmployeeResponse;
import com.employee.data.entity.Employee;

public class DtoConvert {

	public static Employee getCreateEmployeeToEntity(EmployeeCreate employeeCreate) {
		Employee employee = new Employee();

		employee.setFirstName(employeeCreate.getFirstName());
		employee.setLastName(employeeCreate.getLastName());
		employee.setEmail(employeeCreate.getEmail());

		return employee;
	}

	public static Employee getUpdateEmployeeToEntity(EmployeeUpdate employeeUpdate) {
		Employee employee = new Employee();
		employee.setFirstName(employeeUpdate.getFirstName());
		employee.setLastName(employeeUpdate.getLastName());
		employee.setEmail(employeeUpdate.getEmail());

		return employee;
	}

	public static EmployeeResponse getEntityEmployeeResponse(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setId(employee.getId());
		employeeResponse.setFirstName(employee.getFirstName());
		employeeResponse.setLastName(employee.getLastName());
		employeeResponse.setEmail(employee.getEmail());

		return employeeResponse;
	}

}

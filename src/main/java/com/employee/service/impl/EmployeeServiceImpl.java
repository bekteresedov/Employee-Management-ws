package com.employee.service.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employee.data.dto.convert.DtoConvert;
import com.employee.data.dto.request.EmployeeCreate;
import com.employee.data.dto.request.EmployeeUpdate;
import com.employee.data.dto.response.EmployeeResponse;
import com.employee.data.entity.Employee;
import com.employee.data.repository.EmployeeRepository;
import com.employee.enums.ErrorCodeEnum;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.service.EmployeeService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeServiceImpl implements EmployeeService {

	final EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeResponse> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();
		return employees.stream()
				.map(emp -> new EmployeeResponse(emp.getId(), emp.getName(), emp.getSurname(), emp.getEmail()))
				.collect(Collectors.toList());

	}

	@Override
	public EmployeeResponse createEmployee(EmployeeCreate newCEmployeeCreate) {

		return DtoConvert.getEntityEmployeeResponse(
				employeeRepository.save(DtoConvert.getCreateEmployeeToEntity(newCEmployeeCreate)));
	}

	@Override
	public EmployeeResponse findEmployee(Long id) {
		return DtoConvert.getEntityEmployeeResponse(employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND)));
	}

	@Override
	public EmployeeResponse updateEmployeeAll(Long id, EmployeeUpdate newEmployeeUpdate) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {

			Employee foundEmployee = employee.get();

			foundEmployee.setName(newEmployeeUpdate.getName());
			foundEmployee.setSurname(newEmployeeUpdate.getSurname());
			foundEmployee.setEmail(newEmployeeUpdate.getEmail());

			return DtoConvert.getEntityEmployeeResponse(employeeRepository.save(foundEmployee));
		} else
			throw new EmployeeNotFoundException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);

	}

}

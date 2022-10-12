package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.employee.enums.ErrorCodeEnum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeNotFoundException extends RuntimeException {

	final int code;

	final String message;

	public EmployeeNotFoundException(ErrorCodeEnum errorCodeEnum) {
		super(errorCodeEnum.getMessage());

		this.message = errorCodeEnum.getMessage();
		this.code = errorCodeEnum.getCode();
	}

}

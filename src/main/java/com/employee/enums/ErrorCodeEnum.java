package com.employee.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCodeEnum {

	EMPLOYEE_NOT_FOUND(1001, "Can not find Employee with given id"),

	VALIDATION_ERROR(1002, " is not valid "),
	
	UNKNOWN_ERROR(1000," Unknown error"),
	
	ACCESS_DENIED(1003,"Acccess id denied");

	final int code;
	final String message;

}

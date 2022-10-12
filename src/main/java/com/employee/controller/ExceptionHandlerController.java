package com.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.employee.data.dto.response.ErrorResponse;
import com.employee.enums.ErrorCodeEnum;
import com.employee.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(EmployeeNotFoundException.class)

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorResponse handleEmployeeNotFoundException(EmployeeNotFoundException e) {

		return new ErrorResponse(e.getCode(), e.getMessage());
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {

		String pName = e.getParameter().getParameter().getName();
		return new ErrorResponse(ErrorCodeEnum.VALIDATION_ERROR.getCode(),
				pName + ErrorCodeEnum.VALIDATION_ERROR.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

		String fieldMessage = e.getBindingResult().getFieldError().getField();

		return new ErrorResponse(ErrorCodeEnum.VALIDATION_ERROR.getCode(),
				fieldMessage + ErrorCodeEnum.VALIDATION_ERROR.getMessage());
	}

	@ExceptionHandler(AccessDeniedException.class)

	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorResponse handleAccessDeniedException(AccessDeniedException e) {
		return new ErrorResponse(ErrorCodeEnum.ACCESS_DENIED.getCode(), ErrorCodeEnum.ACCESS_DENIED.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleUnknown(Exception e) {
		return new ErrorResponse(ErrorCodeEnum.UNKNOWN_ERROR.getCode(), ErrorCodeEnum.UNKNOWN_ERROR.getMessage());

	}

}

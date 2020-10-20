package com.example.pccw.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.pccw.entity.ExceptionResponse;
import com.example.pccw.exception.GlobalException;

public class ExceptionController {

	@ExceptionHandler(value = GlobalException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse myException(GlobalException e) {
		return new ExceptionResponse(e.getStatus(), e.getMessage());
	}

}

package com.gabriellopesjds.vendasweb.api.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.exeptions.RegraNegocioException;

@ControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MethodArgumentNotValidExceptionHandler methodArgumentNotValidExceptionHandler;
	
	@Autowired
	private RegraNegocioExceptionHandler regraNegocioExceptionHandler;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<BaseResponse<Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
		return methodArgumentNotValidExceptionHandler.handleException(exception);
	}
	
	@ExceptionHandler(RegraNegocioException.class)
	protected ResponseEntity<BaseResponse<Object>> handleRegraNegocioException(RegraNegocioException exception) {
		return regraNegocioExceptionHandler.handleException(exception);
	}
}

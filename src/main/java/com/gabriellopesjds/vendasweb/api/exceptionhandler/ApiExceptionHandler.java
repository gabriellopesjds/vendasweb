package com.gabriellopesjds.vendasweb.api.exceptionhandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.exeptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MethodArgumentNotValidExceptionHandler methodArgumentNotValidExceptionHandler;
	
	@Autowired
	private RegraNegocioExceptionHandler regraNegocioExceptionHandler;

	@Autowired
	private AmazonServiceExceptionHandler amazonServiceExceptionHandler;

	@Autowired
	private AmazonClientExceptionHandler amazonClientExceptionHandler;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<BaseResponse<Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
		return methodArgumentNotValidExceptionHandler.handleException(exception);
	}
	
	@ExceptionHandler(RegraNegocioException.class)
	protected ResponseEntity<BaseResponse<Object>> handleRegraNegocioException(RegraNegocioException exception) {
		return regraNegocioExceptionHandler.handleException(exception);
	}

	@ExceptionHandler(AmazonServiceException.class)
	protected  ResponseEntity<BaseResponse<Object>> handleAmazonServiceException(AmazonServiceException exception){
		return amazonServiceExceptionHandler.handleException(exception);
	}

	@ExceptionHandler(AmazonClientException.class)
	protected  ResponseEntity<BaseResponse<Object>> handleAmazonClientException(AmazonClientException exception){
		return amazonClientExceptionHandler.handleException(exception);
	}
}

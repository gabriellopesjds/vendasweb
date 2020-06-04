package com.gabriellopesjds.vendasweb.api.exceptionhandler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ErrorDetailResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ErrorResponse;

public abstract class AbstractExceptionHandler<T extends Exception> {
	
	public abstract ResponseEntity<BaseResponse<Object>> handleException(T exception);
	
	protected ResponseEntity<BaseResponse<Object>> handleErrorModelResponse(HttpStatus status, String title, List<ErrorDetailResponse> details) {
		ErrorResponse error = new ErrorResponse()
									.status(status.value())
									.title(title)
									.details(details);
		
		return ResponseEntity
				.status(status)
				.body(BaseResponse.withError(error));
	}
}

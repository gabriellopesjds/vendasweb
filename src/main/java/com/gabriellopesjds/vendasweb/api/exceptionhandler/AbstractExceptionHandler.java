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

		return ResponseEntity
				.status(status)
				.body(BaseResponse.withError(buildErrorResponse(status, title, details)));
	}

	private ErrorResponse buildErrorResponse(HttpStatus status, String title, List<ErrorDetailResponse> details) {
		return ErrorResponse
				.builder()
					.status(status.value())
					.title(title)
					.details(details)
				.build();
	}

}

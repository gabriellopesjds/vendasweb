package com.gabriellopesjds.vendasweb.api.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ErrorDetailResponse;

@Component
public class MethodArgumentNotValidExceptionHandler extends AbstractExceptionHandler<MethodArgumentNotValidException>{

	@Override
	public ResponseEntity<BaseResponse<Object>> handleException(MethodArgumentNotValidException exception) {
		List<ErrorDetailResponse> details = 
				exception
					.getBindingResult()
					.getFieldErrors()
					.stream()
					.map(error -> ErrorDetailResponse
								  	.builder()
										.field(error.getField())
										.message(String.format("Field %s %s", error.getField(), error.getDefaultMessage()))
									.build())
					.collect(Collectors.toList());
		
		return handleErrorModelResponse(HttpStatus.BAD_REQUEST, "Service", details);
	}

}

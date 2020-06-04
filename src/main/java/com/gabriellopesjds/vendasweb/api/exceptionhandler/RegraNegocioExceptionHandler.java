package com.gabriellopesjds.vendasweb.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.exeptions.RegraNegocioException;

@Component
public class RegraNegocioExceptionHandler extends AbstractExceptionHandler<RegraNegocioException> {

	@Override
	public ResponseEntity<BaseResponse<Object>> handleException(RegraNegocioException exception) {
		return handleErrorModelResponse(HttpStatus.NOT_FOUND, exception.getMessage(), null);
	}

}

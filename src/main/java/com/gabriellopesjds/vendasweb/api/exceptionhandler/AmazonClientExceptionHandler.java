package com.gabriellopesjds.vendasweb.api.exceptionhandler;

import com.amazonaws.AmazonClientException;
import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AmazonClientExceptionHandler extends AbstractExceptionHandler<AmazonClientException> {

    @Override
    public ResponseEntity<BaseResponse<Object>> handleException(AmazonClientException exception) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(BaseResponse.withError(buildErrorResponse()));
    }

    private ErrorResponse buildErrorResponse() {
        return ErrorResponse
            .builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .title("Client failure Amazon SNS")
            .build();
    }

}

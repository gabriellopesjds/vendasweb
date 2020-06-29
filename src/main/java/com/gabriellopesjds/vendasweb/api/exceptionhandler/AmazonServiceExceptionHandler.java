package com.gabriellopesjds.vendasweb.api.exceptionhandler;

import com.amazonaws.AmazonServiceException;
import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ErrorDetailResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AmazonServiceExceptionHandler extends AbstractExceptionHandler<AmazonServiceException> {

    @Override
    public ResponseEntity<BaseResponse<Object>> handleException(AmazonServiceException exception) {
        return ResponseEntity
            .status(exception.getStatusCode())
            .body(BaseResponse.withError(buildErrorResponse(exception)));
    }

    private ErrorResponse buildErrorResponse(AmazonServiceException exception) {
        return ErrorResponse
                    .builder()
                        .status(exception.getStatusCode())
                        .title("Server failure Amazon SNS")
                        .details(getDetails(exception))
                    .build();
    }

    private List<ErrorDetailResponse> getDetails(AmazonServiceException exception) {
        return Arrays
            .asList(ErrorDetailResponse
                        .builder()
                            .message(exception.getErrorMessage())
                            .code(exception.getErrorCode())
                        .build());
    }
}

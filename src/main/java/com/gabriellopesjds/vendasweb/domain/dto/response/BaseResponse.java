package com.gabriellopesjds.vendasweb.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class BaseResponse<T> {

	private T data;
	private ErrorResponse error;

	public static <T> BaseResponse<T> withData(T data) {
		BaseResponse<T> baseResponse = new BaseResponse<>();
		baseResponse.setData(data);
		return baseResponse;
	}

	public static BaseResponse<Object> withError(ErrorResponse error) {
		BaseResponse<Object> baseResponse = new BaseResponse<>();
		baseResponse.setError(error);
		return baseResponse;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public ErrorResponse getError() {
		return error;
	}
	
	

}

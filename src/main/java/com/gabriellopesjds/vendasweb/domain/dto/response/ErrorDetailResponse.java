package com.gabriellopesjds.vendasweb.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ErrorDetailResponse {
	private String field;
	private String code;
	private String message;
	private String action;
	
	public String getField() {
		return field;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getAction() {
		return action;
	}

	public ErrorDetailResponse field(String field) {
		this.field = field;
		return this;
	}

	public ErrorDetailResponse code(String code) {
		this.code = code;
		return this;
	}

	public ErrorDetailResponse message(String message) {
		this.message = message;
		return this;
	}

	public ErrorDetailResponse action(String action) {
		this.action = action;
		return this;
	}

}

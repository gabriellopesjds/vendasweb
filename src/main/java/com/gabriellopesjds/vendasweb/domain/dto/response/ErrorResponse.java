package com.gabriellopesjds.vendasweb.domain.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ErrorResponse {
	private Integer status;
	private String title;
	private List<ErrorDetailResponse> details;
	
	public Integer getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public List<ErrorDetailResponse> getDetails() {
		return details;
	}

	public ErrorResponse status(Integer status) {
		this.status = status;
		return this;
	}

	public ErrorResponse title(String title) {
		this.title = title;
		return this;
	}

	public ErrorResponse details(List<ErrorDetailResponse> details) {
		this.details = details;
		return this;
	}

}

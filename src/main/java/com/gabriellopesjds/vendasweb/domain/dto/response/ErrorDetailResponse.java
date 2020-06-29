package com.gabriellopesjds.vendasweb.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@Builder
@Getter
@Setter
public class ErrorDetailResponse {
	private String field;
	private String code;
	private String message;
	private String action;
}

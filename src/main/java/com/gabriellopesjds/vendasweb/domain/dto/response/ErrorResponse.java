package com.gabriellopesjds.vendasweb.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(value = Include.NON_NULL)
@Builder
@Getter
@Setter
public class ErrorResponse {
	private Integer status;
	private String title;
	private List<ErrorDetailResponse> details;
}

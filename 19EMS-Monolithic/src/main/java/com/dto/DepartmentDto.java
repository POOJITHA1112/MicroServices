package com.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DepartmentDto {
	
	
    private Long did;
    @NotBlank
	private String dname;
    @NotBlank
	private String dlocation;
}

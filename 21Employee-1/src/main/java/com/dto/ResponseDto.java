package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseDto {

	private DepartmentDto departmentDto;
	private EmployeeDto employeeDto;
}

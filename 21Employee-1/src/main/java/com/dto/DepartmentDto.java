package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentDto {

	private Long did;
	private String dname;
	private String daddress;
	private int dcode;

}

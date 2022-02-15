package com.microservices.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	private Long departmentId;
	private String depratmentName;
	private String departmentAddress;
	private String departmentCode;
}

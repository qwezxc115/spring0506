package org.zerock.domain.ex01;

import lombok.Data;

@Data
public class EmployeeDto {
	private int id;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String photo;
	private String notes;
}

package org.zerock.domain.ex01;

import lombok.Data;

@Data // getter, setter
public class CustomerDto {
	private int customerId;
	private String name;
	private String customerName;
	private String contactName;
	private String postalCode;
	private String address;
	private String city;
	private String country;
}

package com.dionazani.argapura.domain.master.customer;

import lombok.Data;

@Data
public class CustomerDto {
	
	private String id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String bankAccountId;
	
}

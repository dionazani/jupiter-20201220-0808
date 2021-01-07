package com.dionazani.argapura.domain.master.customer;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Data;

@Data
public class CustomerDto {
	
	private String id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private Timestamp createdAt;
	
	private String createdBy;
	
	private Timestamp updatedAt;
	
	private String updatedBy;

	private String bankAccountId;
	
}

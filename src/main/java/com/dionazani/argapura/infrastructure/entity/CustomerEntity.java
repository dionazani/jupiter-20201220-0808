package com.dionazani.argapura.infrastructure.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class CustomerEntity {
	
	@Id  
	@Column(updatable = false, nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	@CreationTimestamp
	private Timestamp createdAt;
	
	private String createdBy;
	
	private Timestamp updatedAt;
	
	private String updatedBy;
	
	private UUID bankAccountId;
	
	private short isDeleted;
	
	@OneToMany(targetEntity=BankAccountEntity.class, mappedBy="bankAccountId",cascade=CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<BankAccountEntity> bankAccount;
}

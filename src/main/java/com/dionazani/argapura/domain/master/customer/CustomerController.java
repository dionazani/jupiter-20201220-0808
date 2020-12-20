package com.dionazani.argapura.domain.master.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dionazani.argapura.infrastructure.dto.ResponseDto;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/master/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/ping")
	public ResponseEntity<Object> ping( ) {
		
		ResponseEntity responseEntity = null;
		
		String message = "PING!";
		
		return responseEntity = ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(message);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNew(@RequestBody CustomerDto dto) {
		
		ResponseEntity responseEntity = null;
		
		try {
			ResponseDto response = this.customerService.addNew(dto);

			responseEntity = ResponseEntity
	                .status(response.getHttpStatusCode())
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(response);
			
		}
		catch(Exception ex) {
			responseEntity = ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(ex.getMessage());
		}
		
		return responseEntity;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateExisting(@PathVariable String id, @RequestBody CustomerDto dto) {
		
		ResponseEntity responseEntity = null;
		
		try {
			ResponseDto response = this.customerService.updateExisting(id, dto);

			responseEntity = ResponseEntity
	                .status(response.getHttpStatusCode())
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(response);
			
		}
		catch(Exception ex) {
			responseEntity = ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(ex.getMessage());
		}
		
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable String id) {
		
		ResponseEntity responseEntity = null;
		
		try {
			ResponseDto response = this.customerService.getById(id);

			responseEntity = ResponseEntity
	                .status(response.getHttpStatusCode())
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(response);
			
		}
		catch(Exception ex) {
			responseEntity = ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(ex.getMessage());
		}
		
		return responseEntity;
	}
}

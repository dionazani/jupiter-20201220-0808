package com.dionazani.argapura.domain.master.customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dionazani.argapura.infrastructure.dto.ResponseDto;
import com.dionazani.argapura.infrastructure.entity.CustomerEntity;
import com.dionazani.argapura.infrastructure.repository.CustomerRepository;
import com.dionazani.argapura.utils.FormatUtils;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public ResponseDto addNew(CustomerDto dto) throws Exception{
		
		ResponseDto response = new ResponseDto();
		
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setUsername(dto.getUsername());
		customerEntity.setPassword(dto.getPassword());
		customerEntity.setEmail(dto.getEmail());
		customerEntity.setFirstName(dto.getFirstName());
		customerEntity.setLastName(dto.getLastName());
		customerEntity.setBankAccountId(UUID.fromString(dto.getBankAccountId()));
		this.customerRepository.save(customerEntity);
		String id = String.valueOf(customerEntity.getId());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		
		response = new ResponseDto();
		response.setHttpStatusCode(200);
		response.setResponseCode("000");
		response.setResponseMessage("Success");
		response.setTimeStamp(FormatUtils.getCurrentTimestamp());
		response.setData(map);
		
		return response;

		
	}
	
	public ResponseDto updateExisting(String id, CustomerDto dto) throws Exception{
		
		ResponseDto response = new ResponseDto();
		
		CustomerEntity customerEntity = this.customerRepository.getOne(UUID.fromString(id));
		customerEntity.setUsername(dto.getUsername());
		customerEntity.setPassword(dto.getPassword());
		customerEntity.setEmail(dto.getEmail());
		customerEntity.setFirstName(dto.getFirstName());
		customerEntity.setLastName(dto.getLastName());
		customerEntity.setBankAccountId(UUID.fromString(dto.getBankAccountId()));
		this.customerRepository.save(customerEntity);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		
		response = new ResponseDto();
		response.setHttpStatusCode(200);
		response.setResponseCode("000");
		response.setResponseMessage("Success");
		response.setTimeStamp(FormatUtils.getCurrentTimestamp());
		response.setData(map);
		
		return response;

	}
	
	public ResponseDto getById(String id) throws Exception{
		
		CustomerDto dto = null;
		ResponseDto response = new ResponseDto();
		
		Optional<CustomerEntity> customerEntity = this.customerRepository.findById(UUID.fromString(id));
		if (customerEntity.isPresent()) {
			dto = new CustomerDto();
			dto.setUsername(customerEntity.get().getUsername());
			dto.setPassword(customerEntity.get().getPassword());
			dto.setEmail(customerEntity.get().getEmail());
			dto.setFirstName(customerEntity.get().getFirstName());
			dto.setLastName(customerEntity.get().getLastName());
			dto.setBankAccountId(String.valueOf(customerEntity.get().getBankAccountId()));
		}
		
		response = new ResponseDto();
		response.setHttpStatusCode(200);
		response.setResponseCode("000");
		response.setResponseMessage("Success");
		response.setTimeStamp(FormatUtils.getCurrentTimestamp());
		response.setData(dto);
		
		return response;

		
	}
}

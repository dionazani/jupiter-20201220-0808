package com.dionazani.argapura.infrastructure.dto;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({ "httpStatusCode"})
public class ResponseDto {
	
	private int httpStatusCode;
	private String responseCode;
	private String responseMessage;
	private Timestamp timeStamp;
	private Object data;
}

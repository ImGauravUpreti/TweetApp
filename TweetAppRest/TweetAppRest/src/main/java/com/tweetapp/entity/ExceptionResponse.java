package com.tweetapp.entity;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**Model class for the business details*/
@Getter
@Setter
public class ExceptionResponse {

	/**
	 * Message thrown by exception
	 */
	private String messge;
	/**
	 * Time stamp of exception
	 */
	private LocalDateTime timestamp;
	/**
	 * Status(HTTP)
	 */
	private HttpStatus status;
	public ExceptionResponse(String messge, LocalDateTime timestamp, HttpStatus status) {
		super();
		this.messge = messge;
		this.timestamp = timestamp;
		this.status = status;
	}
	
	
	
}

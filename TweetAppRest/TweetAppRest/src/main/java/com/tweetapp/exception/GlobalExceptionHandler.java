package com.tweetapp.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tweetapp.entity.ExceptionResponse;

/**Class for handling exceptions*/
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @param userNotFoundException
	 * @return
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userNotFoundException(UserNotFoundException userNotFoundException) {
		
		return new ResponseEntity<>(
				new ExceptionResponse(userNotFoundException.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);

			}
	
	
	/**
	 * @param userExistException
	 * @return
	 */
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<ExceptionResponse> userExistException(UserExistException userExistException) {
		return new ResponseEntity<>(
				new ExceptionResponse(userExistException.getMessage(),LocalDateTime.now(),HttpStatus.ALREADY_REPORTED),
				HttpStatus.ALREADY_REPORTED);

			}
	
	/**
	 * @param userExistException
	 * @return
	 */
	@ExceptionHandler(UserListEmptyException.class)
	public ResponseEntity<ExceptionResponse> userListEmptyException(UserListEmptyException userListEmptyException) {
		return new ResponseEntity<>(
				new ExceptionResponse(userListEmptyException.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);

			}
	
	/**
	 * @param tweetEmptyException
	 * @return
	 */
	@ExceptionHandler(TweetEmptyException.class)
	public ResponseEntity<ExceptionResponse> TweetEmptyException(TweetEmptyException tweetEmptyException) {
		
		return new ResponseEntity<>(
				new ExceptionResponse(tweetEmptyException.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);

			}	
	
	/**
	 * @param tweetEmptyException
	 * @return
	 */
	@ExceptionHandler(TweetNotFoundException.class)
	public ResponseEntity<ExceptionResponse> tweetNotFoundException(TweetNotFoundException tweetNotFoundException) {
		
		return new ResponseEntity<>(
				new ExceptionResponse(tweetNotFoundException.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);

			}	
	
	
	
	
	
}

package com.tweetapp.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserNotFoundException(String message)
	{
		super(message);
	}

}

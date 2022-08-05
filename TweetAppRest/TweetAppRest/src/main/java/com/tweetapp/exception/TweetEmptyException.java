package com.tweetapp.exception;

@SuppressWarnings("serial")
public class TweetEmptyException extends Exception {

	public TweetEmptyException() {
		
	}
	
	public TweetEmptyException(String message)
	{
		super(message);
	}
}

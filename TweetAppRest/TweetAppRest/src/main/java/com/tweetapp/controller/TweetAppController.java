package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.entity.ReplyTweetMessage;
import com.tweetapp.entity.TweetMessage;
import com.tweetapp.entity.UserRegistration;
import com.tweetapp.exception.TweetEmptyException;
import com.tweetapp.exception.TweetNotFoundException;
import com.tweetapp.exception.UserExistException;
import com.tweetapp.exception.UserListEmptyException;
import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.service.RegistrationService;
import com.tweetapp.service.TweetMessageService;

import io.swagger.annotations.ApiOperation;


/*
 * Controller class 
 */
@RequestMapping("/tweets")
@RestController()
@CrossOrigin(origins="http://localhost:3000")
public class TweetAppController {
	@Autowired
	RegistrationService registrationService;
	@Autowired
	TweetMessageService tweetMessage;
	
	@ApiOperation(value = "Registering a new User", response = ResponseEntity.class)
	@PostMapping(value ="/register")
	public ResponseEntity saveUserRegistration(@RequestBody UserRegistration registration) throws UserExistException {
		return registrationService.saveUserRegistration(registration);
		
	}
	@ApiOperation(value = "Getting all Users", response = ResponseEntity.class)
	@GetMapping(value ="/users/all")
	public List<UserRegistration> getUserRegistration() throws UserListEmptyException {
		
		List<UserRegistration> list=registrationService.getAllUser();
		if(list.isEmpty())
		{
			throw new UserListEmptyException("No User found!!!!");
		}
		return list;
		
	}
	
	@ApiOperation(value = "Search a user by username", response = ResponseEntity.class)
	@GetMapping(value ="/user/search/{username}") 
	public UserRegistration getUser(@PathVariable String username) throws UserNotFoundException {
		UserRegistration user =registrationService.getUser(username);
		if(user ==null)
		{
			throw new UserNotFoundException("User NOt FOund!!!");
		}
		
		return user;
		
	}
	
	@ApiOperation(value = "Reset password for a user", response = ResponseEntity.class)
	@PutMapping(value ="/{username}/resetPassword/{oldPassword}/{newPassword}")
	public String updatePassword(@PathVariable String username,@PathVariable String oldPassword,@PathVariable String newPassword) throws Exception  {
		return registrationService.updatePassword(username, oldPassword, newPassword);
		
	}
	
	@ApiOperation(value = "Forget password functionality", response = ResponseEntity.class)
	@PutMapping(value ="/{username}/forgetPassword/{newPassword}")
	public String forgetPassword(@PathVariable String username,@PathVariable String newPassword) throws Exception  {
		return registrationService.forgetPassword(username, newPassword);
		
	}
	@ApiOperation(value = "Logging in service", response = ResponseEntity.class)
	@GetMapping(value ="/login")
	public String login() {
		return "LoggedIn";
		
	}
	@ApiOperation(value = "Getting all Tweets", response = ResponseEntity.class) 
	@GetMapping(value ="/all")
	public List<TweetMessage> getAllTweet()throws TweetEmptyException {
		List<TweetMessage> list=tweetMessage.getAllTweet();
		if(list.isEmpty())
		{
			throw new TweetEmptyException("No tweets found!!!!");
		}
		return list;
		
	}
	@ApiOperation(value = "Add a tweet for a user", response = ResponseEntity.class)
	@PostMapping(value ="/{username}/add")
	public String saveTweetMessage(@PathVariable String username,@RequestBody TweetMessage tweet)  {
		return tweetMessage.postTweet(tweet, username);
		
	}
	
	@ApiOperation(value = "Retrieve a tweet for a user", response = ResponseEntity.class)
	@GetMapping(value ="/{username}")
	public List<TweetMessage> getUserTweet(@PathVariable String username)throws TweetNotFoundException {
		 List<TweetMessage>list=tweetMessage.getUserTweet(username);
		 if(list.isEmpty())
		 {
			 throw new TweetNotFoundException("No tweets found!!!!");
		 }
		 return list;
		
	}
	
	@ApiOperation(value = "Update a tweet for a user", response = ResponseEntity.class)
	@PutMapping(value ="/{username}/update/{id}/{tweet}")
	public String updateTweetMessage(@PathVariable String username,@PathVariable String id,@PathVariable String tweet)  {
		return tweetMessage.updateTweetMessage(username, id, tweet);
		
	}
	
	@ApiOperation(value = "Delete a tweet for a user", response = ResponseEntity.class)
	@DeleteMapping(value ="/{username}/delete/{id}")
	public String deleteTweetMessage(@PathVariable String username,@PathVariable String id)  {
		return tweetMessage.deleteTweetMessage(username, id);
		
	}
	
	@ApiOperation(value = "Reply a tweet", response = ResponseEntity.class)
	@PostMapping(value ="/reply")
	public String saveReplyTweetMessage(@RequestBody ReplyTweetMessage replyTweetMessage)  {
		return tweetMessage.postReplyTweet(replyTweetMessage);
		
	}
	
	@ApiOperation(value = "Like a tweet", response = ResponseEntity.class)
	@PutMapping(value ="/{username}/like/{id}")
	public String updateLike(@PathVariable String username,@PathVariable String id)  {
		return tweetMessage.updateLike(username, id);
		
	}
	
	@ApiOperation(value = "Reply a tweet", response = ResponseEntity.class)
	@GetMapping(value ="/replyTweet/{tweetMessageId}")
	public List<ReplyTweetMessage> getReplyTweet(@PathVariable String tweetMessageId) {
		return tweetMessage.getReplyTweet(tweetMessageId);
		
	}
	
}

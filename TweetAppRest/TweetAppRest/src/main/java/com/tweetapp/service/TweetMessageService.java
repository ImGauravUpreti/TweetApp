package com.tweetapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.entity.ReplyTweetMessage;
import com.tweetapp.entity.TweetMessage;
import com.tweetapp.exception.TweetEmptyException;
import com.tweetapp.exception.TweetNotFoundException;
import com.tweetapp.repository.ReplyTweetMessageRepository;
import com.tweetapp.repository.TweetMessageRepository;
import com.tweetapp.repository.UserRegistrationRepository;

@Service
public class TweetMessageService {
	@Autowired
	TweetMessageRepository tweetMessageRepository;
	@Autowired
	UserRegistrationRepository userRegistrationRepository;
	@Autowired
	ReplyTweetMessageRepository replyTweetMessageRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<TweetMessage> getAllTweet()throws TweetEmptyException {
		logger.info("Entered get all tweet method");
		List<TweetMessage> list=tweetMessageRepository.findAll();
		return list;
		
	}
	public String postTweet(TweetMessage tweetMessage,String username) {
		logger.info("Entered post tweet method");
		
		tweetMessage.setLoginId(username);
		tweetMessageRepository.save(tweetMessage);
		return "saved";
	}
	public List<TweetMessage> getUserTweet(String username) {
		logger.info("Entered get user tweet method");
		return tweetMessageRepository.findByLoginId(username);
		
	}
	public String updateTweetMessage(String username,String id,String tweet) {
		logger.info("Entered update tweet method");
		TweetMessage tweetMessage=tweetMessageRepository.findByIdAndLoginId(id, username);
	    tweetMessage.setTweetMessage(tweet);
		tweetMessageRepository.save(tweetMessage);
				return "updated";
	}
	public String deleteTweetMessage(String username,String id) {
		logger.info("Entered delete tweet method");
		tweetMessageRepository.deleteByIdAndLoginId(id, username);
				return "deleted";
	}
public String postReplyTweet(ReplyTweetMessage replyTweetMessage) {
	logger.info("Entered post reply tweet method");
		
	replyTweetMessageRepository.save(replyTweetMessage);
		return "saved";
	}
public List<ReplyTweetMessage> getReplyTweet(String tweetMessageId) {
	logger.info("Entered get reply tweet method");
	return replyTweetMessageRepository.findByTweetMessageId(tweetMessageId);
	
}

public String updateLike(String username,String id) {
	logger.info("Entered update  tweet like method");
	
	TweetMessage message=tweetMessageRepository.findByIdAndLoginId(id, username);
	int count=message.getLikeCount()+1;
	message.setLikeCount(count);
	tweetMessageRepository.save(message);
	return "updated";
}
	

}

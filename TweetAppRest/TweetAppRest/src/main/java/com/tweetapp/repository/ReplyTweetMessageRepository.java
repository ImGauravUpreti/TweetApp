package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.entity.ReplyTweetMessage;

/*
 * Repository for replying to a tweet
 */
@Repository
public interface ReplyTweetMessageRepository extends MongoRepository<ReplyTweetMessage, String> {

	List<ReplyTweetMessage> findByTweetMessageId(String tweetMessageId);

}

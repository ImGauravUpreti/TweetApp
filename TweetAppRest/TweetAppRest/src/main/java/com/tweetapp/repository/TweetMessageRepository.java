package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweetapp.entity.TweetMessage;
import com.tweetapp.entity.UserRegistration;

/*
 * Repository for adding a tweet
 */
@Repository
public interface TweetMessageRepository extends MongoRepository<TweetMessage, String>{
List<TweetMessage> findByLoginId(String username);
TweetMessage findByIdAndLoginId(String id,String LoginId);
void deleteByIdAndLoginId(String id,String LoginId);
}

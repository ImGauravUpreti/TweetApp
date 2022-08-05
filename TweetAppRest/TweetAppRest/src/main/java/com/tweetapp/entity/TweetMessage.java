package com.tweetapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Entity class for adding a new tweet
 */

@Document(collection = "TweetMessage")
public class TweetMessage {
	@Id
	public String id;
	public String tweetMessage;
	public String tweetTime;
	public int likeCount;
	public String loginId;
	public String getTweetMessage() {
		return tweetMessage;
	}
	public void setTweetMessage(String tweetMessage) {
		this.tweetMessage = tweetMessage;
	}
	public String getTweetTime() {
		return tweetTime;
	}
	public void setTweetTime(String tweetTime) {
		this.tweetTime = tweetTime;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public TweetMessage(String id, String tweetMessage, String tweetTime, int likeCount, String loginId) {
		super();
		this.id = id;
		this.tweetMessage = tweetMessage;
		this.tweetTime = tweetTime;
		this.likeCount = likeCount;
		this.loginId = loginId;
	}
	public TweetMessage() {
		super();
	}
	
	
	

}

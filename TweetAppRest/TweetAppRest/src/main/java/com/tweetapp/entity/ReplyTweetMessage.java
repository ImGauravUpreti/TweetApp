package com.tweetapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
 * Entity class for replying tweet
 */
@Document(collection="ReplyTweetMessage")
public class ReplyTweetMessage {
	@Id
	public String id;
	public String replyMessage;
	public String tweetMessageId;
	public String loginId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReplyMessage() {
		return replyMessage;
	}
	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}
	public String getTweetMessageId() {
		return tweetMessageId;
	}
	public void setTweetMessageId(String tweetMessageId) {
		this.tweetMessageId = tweetMessageId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	

}

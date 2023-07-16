package com.Basic.Tweeting.and.Commenting.System.Entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tweet 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int tweetId;
	String tweetContent;
	@CreationTimestamp
	LocalDateTime timeOfTweet;

	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tweet(String tweetContent, User user) {
		super();
		this.tweetContent = tweetContent;
		this.user = user;
	}

	public Tweet(int tweetId, String tweetContent, LocalDateTime timeOfTweet, User user) {
		super();
		this.tweetId = tweetId;
		this.tweetContent = tweetContent;
		this.timeOfTweet = timeOfTweet;
		this.user = user;
	}
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweetContent() {
		return tweetContent;
	}
	public void setTweetContent(String tweetContent) {
		this.tweetContent = tweetContent;
	}
	public LocalDateTime getTimeOfTweet() {
		return timeOfTweet;
	}
	public void setTimeOfTweet(LocalDateTime timeOfTweet) {
		this.timeOfTweet = timeOfTweet;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", tweetContent=" + tweetContent + ", timeOfTweet=" + timeOfTweet
				+ "]";
	}



}

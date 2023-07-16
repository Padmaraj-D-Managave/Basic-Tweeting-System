package com.Basic.Tweeting.and.Commenting.System.Entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User 
{
	@Id
	int userId;

	@OneToMany
	List<Tweet> tweets;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, List<Tweet> tweets) {
		super();
		this.userId = userId;
		this.tweets = tweets;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId +  "]";
	}
	
	
}

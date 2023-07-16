package com.Basic.Tweeting.and.Commenting.System.Service;

import java.util.List;
import com.Basic.Tweeting.and.Commenting.System.Entity.Tweet;
import com.Basic.Tweeting.and.Commenting.System.Entity.User;

public interface TweetService 
{

	String addTweet(Tweet tweet);

	Tweet getTweetById(int tweetId);

	List<Tweet> getAllTweetId();

	Tweet deleteTweet(int tweetId);

	List<Tweet> getTweetPerUser(User user);
	
}

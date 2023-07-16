package com.Basic.Tweeting.and.Commenting.System.Controller;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Basic.Tweeting.and.Commenting.System.Entity.Tweet;
import com.Basic.Tweeting.and.Commenting.System.Entity.User;
import com.Basic.Tweeting.and.Commenting.System.Service.TweetService;
import com.Basic.Tweeting.and.Commenting.System.Service.UserService;

@RestController
@RequestMapping
public class TweetController 
{
	@Autowired
	TweetService ts;

	@Autowired
	UserService us;

	@PostMapping("/createTweet")
	public String createTweet(@RequestBody Tweet tweet ) {
		User user1 = tweet.getUser();
		int userId = user1.getUserId();

		boolean searchUser = us.searchUser(userId);
		if(searchUser)
		{
			String addTweet = ts.addTweet(tweet);
			return "Tweet "+addTweet;
		}else {
			return "No User with userId: "+userId;
		}
	}

	@GetMapping("/getByTweetid/{tweetId}")
	public String getTweetsById(@PathVariable("tweetId") int tweetId ) {
		try {
			Tweet allTweetId = ts.getTweetById(tweetId);
			return allTweetId.toString();
		} catch (Exception e) {
			// TODO: handle exception
			return "No Tweet with tweetId: "+tweetId;
		}
	}

	@GetMapping("/getAllTweet")
	public List<Tweet> getAllTweet() {
		List<Tweet> allTweetId = ts.getAllTweetId();
		return allTweetId;
	}

	@GetMapping("/getTweetPerUser/{userId}")
	public List getTweetsPerUser(@PathVariable("userId")int userId) {
		boolean searchUser = us.searchUser(userId);
		if(searchUser)
		{
			User userById = us.getUserById(userId);
			List<Tweet> tweets = ts.getTweetPerUser(userById);
			if(tweets.size()>0) {
				return tweets;
			}else {
				List<String> arrayList = new ArrayList<>();
				arrayList.add("User with Id ("+userId+") not yet tweeted any tweet/s.");
				return arrayList;
			}

		}else {
			List<String> arrayList = new ArrayList<>();
			arrayList.add("No such User with Id : "+userId);
			return arrayList;
		}

	}


	@PutMapping("/updateTweet/{tweetId}")
	public String updateTweet(@PathVariable("tweetId") int tweetId,@RequestBody Tweet tweet) {
		try {
			String tweetContent = tweet.getTweetContent();
			Tweet allTweetId = ts.getTweetById(tweetId);
			allTweetId.setTweetContent(tweetContent);
			allTweetId.setTimeOfTweet(LocalDateTime.now());
			String addTweet = ts.addTweet(allTweetId);
			return addTweet;
		} catch (Exception e) {
			// TODO: handle exception
			return "No Tweet with tweetId: "+tweetId;
		}

	}

	@DeleteMapping("/deleteTweet/{tweetId}")
	public String deleteTweet(@PathVariable("tweetId") int tweetId) {

		Tweet deleteTweet = ts.deleteTweet(tweetId);
		if(deleteTweet==null)
		{
			return "No Tweet with tweetId: "+tweetId;
		}else {
			return "Tweet with twwetId "+tweetId+" is Deleted";
		}

	}

}

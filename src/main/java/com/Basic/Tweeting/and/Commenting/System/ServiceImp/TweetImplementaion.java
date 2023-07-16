package com.Basic.Tweeting.and.Commenting.System.ServiceImp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Basic.Tweeting.and.Commenting.System.Entity.Tweet;
import com.Basic.Tweeting.and.Commenting.System.Entity.User;
import com.Basic.Tweeting.and.Commenting.System.Repository.TweetRepository;
import com.Basic.Tweeting.and.Commenting.System.Service.TweetService;
@Service
public class TweetImplementaion implements TweetService
{
	@Autowired
	TweetRepository tweetRepo;

	@Override
	public String addTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		Tweet save = tweetRepo.save(tweet);
		if(save!=null)
		{
			return "added";
		}else {
			return "failed";
		}

	}

	@Override
	public Tweet getTweetById(int tweetId) {
		// TODO Auto-generated method stub
		Tweet tweet = tweetRepo.findById(tweetId).get();
		return tweet;
	}

	@Override
	public List<Tweet> getAllTweetId() {
		// TODO Auto-generated method stub
		List<Tweet> findAll = tweetRepo.findAll();
		return findAll;
	}

	@Override
	public Tweet deleteTweet(int tweetId) {
		// TODO Auto-generated method stub
		try {
			Tweet tweet = tweetRepo.findById(tweetId).get();
			tweetRepo.deleteById(tweetId);
			return tweet;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}


	}

	@Override
	public List<Tweet> getTweetPerUser(User userId) {
		// TODO Auto-generated method stub
		List<Tweet> findByUser = tweetRepo.findByUser(userId); 
		return findByUser;
	}

}

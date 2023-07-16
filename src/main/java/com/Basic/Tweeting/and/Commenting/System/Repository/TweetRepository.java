package com.Basic.Tweeting.and.Commenting.System.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Basic.Tweeting.and.Commenting.System.Entity.Tweet;
import com.Basic.Tweeting.and.Commenting.System.Entity.User;

public interface TweetRepository extends JpaRepository<Tweet, Integer> 
{

	

	 List<Tweet> findByUser(User userId);

}

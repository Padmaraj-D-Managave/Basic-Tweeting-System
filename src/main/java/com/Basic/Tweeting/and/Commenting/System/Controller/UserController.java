package com.Basic.Tweeting.and.Commenting.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Basic.Tweeting.and.Commenting.System.Entity.User;
import com.Basic.Tweeting.and.Commenting.System.Service.UserService;

@RestController
@RequestMapping
public class UserController 
{
	@Autowired
	UserService us;
	
	
	@PostMapping("/addUser")
	public String  addUser(@RequestBody User user) {
		
		int userId = user.getUserId();
		
		boolean searchUser = us.searchUser(userId);
		if(searchUser )
		{
			
			return "Please Change the user Id.Because Alredy Present.";
		}else {
			int addUser = us.addUser(user);
			return "User Id is: "+addUser;
		}
		
		
		
	}
}

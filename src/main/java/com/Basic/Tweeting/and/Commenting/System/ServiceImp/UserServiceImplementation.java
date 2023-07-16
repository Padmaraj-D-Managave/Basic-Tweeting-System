package com.Basic.Tweeting.and.Commenting.System.ServiceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Basic.Tweeting.and.Commenting.System.Entity.User;
import com.Basic.Tweeting.and.Commenting.System.Repository.UserRepository;
import com.Basic.Tweeting.and.Commenting.System.Service.UserService;

@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	UserRepository userRepo;

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		User save = userRepo.save(user);
		int userId = save.getUserId();
		return userId;
	}

	@Override
	public boolean searchUser(int userId) {
		// TODO Auto-generated method stub
		try {
			User user = userRepo.findById(userId).get();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}


	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).get();
		return user;

	}

}

package com.Basic.Tweeting.and.Commenting.System.Service;

import com.Basic.Tweeting.and.Commenting.System.Entity.User;

public interface UserService {

	int addUser(User user);

	boolean searchUser(int userId);

	User getUserById(int userId);

}

package com.Basic.Tweeting.and.Commenting.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Basic.Tweeting.and.Commenting.System.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

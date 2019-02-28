package com.rumango.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumango.entity.User;
import com.rumango.repo.UserRepo;

@Service
public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private UserRepo userRepo;

	public User lastLoginService(User user)
	{
		User u = new User();
		try
		{
			user.setFailedAttempts(0);

			Date date = new Date();

			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdt = sm.format(date);
			Date dt = sm.parse(sdt);
			java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
			Timestamp timestam = (new Timestamp(System.currentTimeMillis()));
			u = user;
			userRepo.updateLastLogin(timestam,user.getUserId());
			System.err.println(user.getLogoutTime());
			//System.err.println("Extra copy "+u);
			//System.err.println(sqlDate+"  "+ user.getUserId());
			//userRepo.updateLastLogin(sqlDate, user.getUserId());
			//user.setLogoutTime(sqlDate);
			//int signCount = user.getSignInCount();
			//user.setSignInCount(signCount+1);
			System.err.println("Original copy "+user);
			//u.setLogoutTime(user.getLogoutTime());
			//userRepo.save(user);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return u;
	}

}

package com.rumango.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumango.entity.Login;
import com.rumango.entity.User;
import com.rumango.repo.LoginRepository;
import com.rumango.repo.UserRepo;

@Service
public class LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	UserRepo userRepository;

	public LoginService() {

	}

	public User userLoginService(Login login) {
		logger.info("userLogin Service method started");

		logger.info("login ::" + login);

		String userId = login.getUsername();
		User user = null;
		User preUser = userRepository.findByUserId(userId);
		System.out.println(preUser);
		try {
			user = loginRepository.fetchUserDetails(userId);

		} catch (Exception e) {
			logger.error("Exception occurred in userLoginService method ", e);
		}

		logger.info("userLoginService method ended");

		return user;
	}

}

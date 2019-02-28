package com.rumango.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumango.entity.Login;
import com.rumango.entity.User;
import com.rumango.repo.UserRepo;
import com.rumango.service.LoginService;
import com.rumango.service.UserService;

@CrossOrigin(origins = "*")
@RequestMapping("/login")
@RestController
public class LoginController {
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpServletRequest request;
	@Autowired
	UserRepo userRepository;

	@Autowired
	private UserService userService;

	private BCryptPasswordEncoder encoder = passwordEncoder();

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public LoginController() {
		// logger.info("Created\t"+this.getClass().getSimpleName());
		logger.info("Created\t" + this.getClass().getSimpleName());
	}

//	@PostMapping("/credentials")
//	public User userLoginController(@RequestBody Login login)
//	{
//		//logger.info("userLoginController method started");
//
//		HttpSession session = request.getSession();
//		
//		User user = null;
//		//String passFromDb="";			
//		try {
//			String userId = login.getUsername();
//			String userPwd = login.getPassword();
//			String lastLogin = null;
//			System.err.println(login);
//			user = loginService.userLoginService(login);
//			System.err.println(user);
//			if(user!=null)
//			{ 
//				boolean loginStatus = encoder.matches(userPwd,  user.getEncryptedPassword());
//				logger.info(loginStatus);
//				if(loginStatus)
//				{
//					//loginService.lastLoginService(userId, date);
//					session.setAttribute("loggedInUser", user);
//					logger.info("login sucessful "+userId);
//					//logger.info("login sucessful "+userId);
//					return user;
//				}
//				else
//				{
//					System.err.println("Invalid Credentials");
//					
//					Date date = new Date();
//					
//					User invalid = new User();
//					
//					return null;
//				}
//			}
//			else
//			{
//				System.err.println("password wrong");
//				return null;
//				//logger.info("password wrong");
//			}
//		}
//		catch (Exception e)
//		{
//			
//			e.printStackTrace();
//		}
//
//		
//		
//		return null;
//	}

	@PostMapping(value = "/credentials")
	// consumes=MediaType.APPLICATION_JSON_VALUE,
	// produces=MediaType.APPLICATION_JSON_VALUE)
	public User userLoginController(@RequestBody Login login) {
		// logger.info("userLoginController method started");
		logger.info("login::" + login);
		HttpSession session = request.getSession();
		User user = userRepository.findByUserId(login.getUsername());
		// User user = null;
		// String passFromDb="";
		try {
			String userId = login.getUsername();
			String userPwd = login.getPassword();
			user = loginService.userLoginService(login);
			System.err.println(user);
			if (user != null) {
				boolean loginStatus = encoder.matches(userPwd, user.getEncryptedPassword());
				logger.info("loginStatus::" + loginStatus);
				if (loginStatus) {
					session.setAttribute("loggedInUser", user);
					logger.info("login sucessful " + userId);

					User u = userService.lastLoginService(user);
					System.err.println("contoller " + u);

					return u;
				} else {
					int failCount = user.getFailedAttempts();
					logger.info("failCount " + failCount);
					user.setFailedAttempts(failCount + 1);
					logger.info(user.getFailedAttempts().toString());
					// User updatedUser=service.createUserService(user);
					userRepository.save(user);
					logger.info(user.toString());
					System.err.println("Invalid Credentials");
					Date date = new Date();
					// loginService.lastFailLgnService(userId, date);
					return null;
				}
			} else {
				System.err.println("password wrong");
				return null;
				// logger.info("password wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("userLoginController method ended");

		return null;
	}
}
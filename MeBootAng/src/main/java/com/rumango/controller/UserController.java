package com.rumango.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumango.entity.AuditLog;
import com.rumango.entity.User;
import com.rumango.repo.AuditRepo;
import com.rumango.repo.UserRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepo userRepository;
	@Autowired
	AuditRepo auditRepo;
	@Autowired
	private JavaMailSender sender;

//	@Autowired
//	private RolesRepo rolesRepo;

	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	// create user
	@PostMapping(value = "/createUser")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public User postUser(@RequestBody User entity) throws MessagingException {

		logger.info("User Entity post method start" + entity);
		AuditLog audit = new AuditLog();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(entity.getEncryptedPassword());
		logger.info("inside UserController-postUser ");
		// send mail
		
//		MimeMessage message = sender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        helper.setTo(entity.getEmail());
//        helper.setText("Greetings :)");
//        helper.setSubject("Mail From Spring Boot 2");
//        sender.send(message);
	
		entity.setCreatorDtStamp(sqlDate); // setCreatedAt(sqlDate);
		// entity.setUpdatedAt(sqlDate);
		entity.setAuthStatus("U");
		entity.setFristTimeAuth("U");
		entity.setRecordStatus("O");
		entity.setSignInCount(1);// implement in login service
		//entity.setCreatorId(entity.getUserId());
		entity.setFailedAttempts(1);// implement in login service
		entity.getRoleForUser();
		entity.setVersionNo(1);
		entity.setEncryptedPassword(hashedPassword);
		User u = userRepository.findByUserId(entity.getUserId());
		System.out.println(u);
		if ( u == null) {
			audit.setAction("created");
			//audit.setLoggableType("user create");
			
			audit.setCreatorId(entity.getCreatorId());// this should be come from creater (logged in user) of new user
			audit.setCreatorDtStamp(sqlDate);
			audit.setUpdatedAt(sqlDate);
			audit.setRecord(entity.getUserId());
			audit.setActionPerformBy(entity.getCreatorId());
			logger.info("user create audit log");
			userRepository.save(entity);
			auditRepo.save(audit);
			logger.info("Successfuliy created");
		}

		logger.info("User Entity" + entity);
		

		logger.info("User Entity post method end");
		return entity;
	}

	// get all users
	@GetMapping("/fetchAllUser")
	public List<User> getAllUsers() {
		logger.info("inside UserController-getAllUsers ");

		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		logger.info("inside UserController-getAllCustomers " + users);
		logger.info("User Entity get all user method end");
		return users;
	}

//delete user through id
	@DeleteMapping("{userId}/{userIdLoggedIn}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("inside UserController-deleteUserby userid ");
		AuditLog audit = new AuditLog();
		User u = userRepository.findByUserId(userId);
		logger.info("user status is" + u.getAuthStatus());
		if (u.getAuthStatus().equalsIgnoreCase("U")) {
			logger.info("user is deleted");
			userRepository.deleteByUserId(userId);
			audit.setAction("deleted");
			audit.setActionPerformBy(userIdLoggedIn);
			audit.setCreatorId(u.getCreatorId());// this should be come from creater (logged in user) of new user
			audit.setCreatorDtStamp(u.getCreatorDtStamp());
			audit.setUpdatedAt(sqlDate);
			auditRepo.save(audit);
		} else {
			return new ResponseEntity<>("user is authorized you can't delete!", HttpStatus.OK);
		}

		return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
	}

	// verify user
	@GetMapping("/verify/{userId}/{userIdLoggedIn}")
	public User verifyUser(@PathVariable("userId") String userId,
			@PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		System.err.println("userIdLoggedIn : " + userIdLoggedIn);
		logger.info("verify method call");
		logger.info("inside UserController-verify user ");
		AuditLog audit = new AuditLog();
		User u = userRepository.findByUserId(userId);
		u.setAuthStatus("A");
		u.setFristTimeAuth("A");
		u.setVerifierId(userIdLoggedIn);
		u.setVerifierDtStamp(sqlDate);
	
		if (userRepository.save(u) != null) {
			audit.setAction("verified");
			//audit.setLoggableType("user verified");
			audit.setRecord(userId);
			audit.setUpdatedAt(sqlDate);
			audit.setVerifierId(userIdLoggedIn);
			audit.setVerifierDtStamp(sqlDate);
			audit.setActionPerformBy(userIdLoggedIn);
			audit.setCreatorId(u.getCreatorId());
			audit.setCreatorDtStamp(u.getCreatorDtStamp());
			audit.setVerifierId(userIdLoggedIn); // setCreatorId(entity.getUserId());// this should be come from creater
													// (logged in user) of new user
			audit.setVerifierDtStamp(sqlDate); // setUpdatedAt(sqlDate);
			logger.info("user verified log");
			auditRepo.save(audit);



			userRepository.save(u);
			logger.info("verify method end");

		} // else ends
		return u;

	}

// close a record
	@GetMapping("/close/{userId}/{userIdLoggedIn}")
	public User closeRecordUser(@PathVariable("userId") String userId, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("verify method call");
		logger.info("inside UserController-closeRecordUser user ");
		AuditLog audit = new AuditLog();
		User u = userRepository.findByUserId(userId);
		u.setRecordStatus("C");
		userRepository.save(u);
		//audit
		audit.setCreatorId(u.getCreatorId());
		audit.setCreatorDtStamp(u.getCreatorDtStamp());
		audit.setAction("user Closed");
		audit.setRecord(userId);
		audit.setUpdatedAt(sqlDate);
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
		logger.info("closeRecordUser method end");
		return u;
	}

	// re open a record user
	@GetMapping("/reOpen/{userId}/{userIdLoggedIn}")
	public User reopenRecord(@PathVariable("userId") String userId, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("verify method call");
		logger.info("inside UserController-reopenRecord user ");
		User u = userRepository.findByUserId(userId);
		AuditLog audit = new AuditLog();
		u.setRecordStatus("O");
		userRepository.save(u);
		//audit
		audit.setCreatorId(u.getCreatorId());
		audit.setCreatorDtStamp(u.getCreatorDtStamp());
		audit.setAction("reopen");
		audit.setRecord(userId);
		audit.setUpdatedAt(sqlDate);
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
		logger.info("reopenRecord method end");
		return u;
	}

//@GetMapping("/logoutTime/{userId}")
//public void logoutTime() {
//	User u1=userRepository.getOne(userId);
//	User u = userRepository.findByUserId(userId);	
//}
	@PutMapping("/modifyUser")
	public void updateUserByIdController(@RequestBody User user) {
		logger.info("update User Id Controller method started");

		User preUser = userRepository.findByUserId(user.getUserId());
		preUser.setUserName(user.getUserName());
		preUser.setEmail(user.getEmail());
		preUser.setMobile(user.getMobile());
		System.out.println("Old Password :::"+user.getEncryptedPassword());
		preUser.setEncryptedPassword(user.getEncryptedPassword());
		//System.out.println("preUser Password :::"+preUser.getEncryptedPassword());
		preUser.setUpdatedBy(user.getUserId());
		preUser.setAuthStatus("U");
		preUser.setUpdatedAt(sqlDate);
		preUser.setVersionNo(preUser.getVersionNo() + 1);
		// preUser.setCreatorDtStamp(sqlDate); //setCreatedAt(sqlDate);
		userRepository.save(preUser);
		
		
		//audit
		AuditLog audit = new AuditLog();
		audit.setCreatorId(preUser.getCreatorId());
		audit.setCreatorDtStamp(preUser.getCreatorDtStamp());
		audit.setAction("modification");
		audit.setActionPerformBy(user.getUpdatedBy());
		audit.setRecord(preUser.getUserId());
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
	}
//		 if (User==null) {
//	            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//	        }
//		// userRepository.save(user);
//	        return new ResponseEntity<String>(HttpStatus.OK);
//	        

//		try
//		{
//			logger.info("inside update method");
//			userRepository.save(user);
//			System.err.println(user);
//		}
//		catch (Exception e)
//		{
//			logger.error("Exception occurred in updateUserByIdController method");
//			System.err.println("Exception occurred in updateUserByIdController method");
//			e.printStackTrace();
//		}
//
//		logger.info("updateUserByIdController method ended");
//
//		return true;

//	 @RequestMapping(method=RequestMethod.PUT, value="/contacts/{id}")
//	    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
//	        Contact c = contactRepository.findOne(id);
//	        if(contact.getName() != null)
//	            c.setName(contact.getName());
//	        if(contact.getAddress() != null)
//	            c.setAddress(contact.getAddress());
//	        if(contact.getCity() != null)
//	            c.setCity(contact.getCity());
//	        if(contact.getPhone() != null)
//	            c.setPhone(contact.getPhone());
//	        if(contact.getEmail() != null)
//	            c.setEmail(contact.getEmail());
//	        contactRepository.save(c);
//	        return contact;
//	    }	
	public String sendMail() {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo("prabhatgenji@gmail.com");
			helper.setText("Greetings :)");
			helper.setSubject("Mail From Spring Boot 2");
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}

		return "Mail Sent Success!";
	}
	
}

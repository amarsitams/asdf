package com.rumango.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumango.entity.AuditLog;
import com.rumango.repo.AuditRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/api")
public class ApiController {
	 private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	AuditRepo auditRepository;
	
	
	// this is for audit and dashboard
	// audit logs
	//get all audit logs
			@GetMapping("/auditsList")
			public List<AuditLog> getAllAuditLogs() {
				logger.info("Get all AuditLog data...");
				System.out.println("Get all AuditLog data...");
		 
				List<AuditLog> auditsall = new ArrayList<>();
				auditRepository.findAll().forEach(auditsall::add);
		          System.out.println(auditsall);
				return auditsall;
			}

		
		
			
			@GetMapping("/403")
		    public String error403() {
		        return "/error/403";
		    }
}

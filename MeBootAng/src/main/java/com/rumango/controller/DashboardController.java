//package com.rumango.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.rumango.entity.ExternalSystem;
//import com.rumango.entity.User;
//import com.rumango.repo.AuditRepo;
//import com.rumango.repo.ExtSysRepo;
//import com.rumango.repo.TagRepo;
//import com.rumango.repo.UserRepo;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders="*")
//@RequestMapping("/api")
//public class DashboardController {
//	@Autowired
//	UserRepo userRepository;
//	@Autowired
//	AuditRepo auditRepository;
//	@Autowired
//	ExtSysRepo esp;
//	@Autowired
//	TagRepo tagRepo;
//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
////	@GetMapping("/dashboardchartdata")
////	List<Long> countUser() {
////		Long contUser=userRepository.count();
////		Long countAudit=auditRepository.count();
////		Long countExtSys=esp.count();
////		List<Long> ds=new ArrayList<>();
////		ds.add(contUser);
////		ds.add(countAudit);
////		ds.add(countExtSys);
////		System.out.println(ds);
////		return ds;
////	}
//	
//}

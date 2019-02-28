package com.rumango.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.rumango.entity.ExternalSystem;
import com.rumango.repo.AuditRepo;
import com.rumango.repo.ExtSysRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/extsys")
public class ExtSysController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AuditRepo auditRepo;

	@Autowired
	AuditRepo auditRepository;
	@Autowired
	ExtSysRepo extSysRepository;

	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	// create ext sys
	@PostMapping(value = "/createExtSys")
	public ExternalSystem postExt(@RequestBody ExternalSystem entity) {
		logger.info("create new external system");
		// System.out.println("save external system in db.");
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		AuditLog audit = new AuditLog();
		entity.setCreatedAt(sqlDate);
		entity.setCreatorDtStamp(sqlDate);
		entity.setCreatorId(entity.getCreatorId());
		entity.setUpdatedAt(sqlDate);
		entity.setAuthStatus("U");
		entity.setRecordStatus("O");
		entity.setAuthStatus("U");

		ExternalSystem u = extSysRepository.findByExtSysName(entity.getExtSysName());
		// System.out.println(u);
		// extSysRepository.save(entity) != null &&
		if (extSysRepository.save(entity) != null && u == null) {
			extSysRepository.save(entity);
			audit.setAction("created");
			audit.setRecord(entity.getExtSysCode());
			// audit.setCreatorDtStamp(sqlDate);
			audit.setUpdatedAt(sqlDate);
			audit.setCreatorId(entity.getCreatorId());
			audit.setActionPerformBy(entity.getCreatorId());
			auditRepo.save(audit);
			auditRepo.save(audit);
			logger.info("successfully ext system created");
		}
		// extSysRepository.save(entity);

		return entity;
	}

	// get all ext sys
	@GetMapping("/extsysdata")
	public List<ExternalSystem> getAllExtSys() {
		logger.info("Get all external system  ext controller data...");
		// System.out.println("Get all Ext Sys data...");

		List<ExternalSystem> extdata = new ArrayList<>();
		extSysRepository.findAll().forEach(extdata::add);
		// System.out.println(extdata);
		logger.info("all external system data fetching");
		return extdata;
	}
//	@GetMapping("/fetchAllExtSys")
//	public List<ExternalSystem> getAllExtSys2() {
//		logger.info("inside UserController-getAllUsers ");
//
//		List<ExternalSystem> extSys = new ArrayList<>();
//		extSysRepository.findAll().forEach(extSys::add);
//		logger.info("inside UserController-getAllCustomers " + extSys);
//		logger.info("User Entity get all user method end");
//		return extSys;
//	}	

//delete ext through extSysName
	@DeleteMapping("{extSysName}/{userIdLoggedIn}")
	public ResponseEntity<String> deleteExtSystem(@PathVariable("extSysName") String extSysName,
			@PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("inside extController-deleteextby extSysName ");
		AuditLog audit = new AuditLog();
		ExternalSystem extSys = extSysRepository.findByExtSysName(extSysName);
		logger.info("extSys status is" + extSys.getAuthStatus());
		if (extSys.getAuthStatus().equalsIgnoreCase("U")) {
			logger.info("extSys is deleted");
			extSysRepository.deleteByExtSysName(extSysName);
			audit.setAction("deleted");
			audit.setRecord(extSysName);
			audit.setActionPerformBy(userIdLoggedIn);
			audit.setUpdatedAt(sqlDate);
			audit.setCreatorId(extSys.getCreatorId());// this should be come from creater (logged in user) of new user
			audit.setCreatorDtStamp(extSys.getCreatorDtStamp());
			audit.setUpdatedAt(sqlDate);
			auditRepo.save(audit);
		} else {
			return new ResponseEntity<>("extSys is authorized you can't delete!", HttpStatus.OK);
		}

		return new ResponseEntity<>("extSys has been deleted!", HttpStatus.OK);
	}

	// verify ext sys
	@GetMapping("/verify/{extSysName}/{userIdLoggedIn}")
	public ExternalSystem verifyUser(@PathVariable("extSysName") String extSysName,
			@PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		System.err.println("userIdLoggedIn : " + userIdLoggedIn);
		logger.info("verify method call");
		logger.info("inside UserController-verify user ");
		AuditLog audit = new AuditLog();
		ExternalSystem extSys = extSysRepository.findByExtSysName(extSysName);
		extSys.setAuthStatus("A");
		extSys.setVerifierId(userIdLoggedIn);
		extSys.setVerifierDtStamp(sqlDate);

		if (extSysRepository.save(extSys) != null) {
			audit.setAction("verified");
			audit.setRecord(extSysName);

			audit.setUpdatedAt(sqlDate);
			audit.setVerifierId(userIdLoggedIn);
			audit.setVerifierDtStamp(sqlDate);
			audit.setCreatorId(extSys.getCreatorId());
			audit.setActionPerformBy(userIdLoggedIn);
			// audit.setCreatorDtStamp(extSys.getCreatorDtStamp());
			audit.setVerifierId(userIdLoggedIn); // setCreatorId(entity.getUserId());// this should be come from creater
													// (logged in user) of new user
			audit.setVerifierDtStamp(sqlDate); // setUpdatedAt(sqlDate);
			logger.info("user verified log");
			auditRepo.save(audit);

			extSysRepository.save(extSys);
			logger.info("verify method end");

		} // else ends
		return extSys;

	}

// close a record
	@GetMapping("/close/{extSysName}/{userIdLoggedIn}")
	public ExternalSystem closeRecordUser(@PathVariable("extSysName") String extSysName,
			@PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("close method call");
		logger.info("inside close ext sys ");
		AuditLog audit = new AuditLog();
		ExternalSystem extSys = extSysRepository.findByExtSysName(extSysName);
		extSys.setRecordStatus("C");
		extSysRepository.save(extSys);
		// audit
		audit.setCreatorId(extSys.getCreatorId());
		audit.setCreatorDtStamp(extSys.getCreatorDtStamp());
		audit.setAction("ext sys Closed");
		audit.setRecord(extSysName);
		audit.setUpdatedAt(sqlDate);
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
		logger.info("closeRecordext method end");
		return extSys;
	}

	// re open a record user
	@GetMapping("/reOpen/{extSysName}/{userIdLoggedIn}")
	public ExternalSystem reopenRecord(@PathVariable("extSysName") String extSysName,
			@PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("reopen method call");
		logger.info("inside reopenRecord ext ");
		ExternalSystem extSys = extSysRepository.findByExtSysName(extSysName);
		AuditLog audit = new AuditLog();
		extSys.setRecordStatus("O");
		extSysRepository.save(extSys);
		// audit
		audit.setCreatorId(extSys.getCreatorId());
		audit.setCreatorDtStamp(extSys.getCreatorDtStamp());
		audit.setAction("reopen");
		audit.setRecord(extSysName);
		audit.setUpdatedAt(sqlDate);
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
		logger.info("reopenRecord method end");
		return extSys;
	}

	@GetMapping("/fetchAuthExtSystem")
	public List<ExternalSystem> fetchAllAuthRolesController() {
		List<ExternalSystem> list = extSysRepository.fetchAuthAuthExtSystem();

		return list;
	}

	@PutMapping("/modifyextSys")
	public void updateUserByIdController(@RequestBody ExternalSystem ext) {
		logger.info("update User Id Controller method started");

		ExternalSystem extSys = extSysRepository.findByExtSysName(ext.getExtSysName());
		extSys.setDestination(ext.getDestination());
		extSys.setCommChannel(ext.getCommChannel());
		extSys.setDestinationTag(ext.getDestinationTag());
		extSys.setDtdFile(ext.getDtdFile());
		extSys.setErrDirectoryName(ext.getErrDirectoryName());
		extSys.setErrQueueName(ext.getErrQueueName());
		extSys.setErrSchemaName(ext.getErrSchemaName());
		extSys.setErrXsltName(ext.getErrXsltName());
		extSys.setExtSysCode(ext.getExtSysCode());
		extSys.setExtSysName(ext.getExtSysName());
		extSys.setExtSysTag(ext.getExtSysTag());
		extSys.setFormatType(ext.getFormatType());
		extSys.setIsDestNode(ext.getIsDestNode());
		extSys.setIsExtSysNode(ext.getIsExtSysNode());
		extSys.setIsModuleNode(ext.getIsModuleNode());
		extSys.setIsProcessNode(ext.getIsProcessNode());
		extSys.setIsServiceNode(ext.getIsServiceNode());
		extSys.setLatestAmendNo(ext.getLatestAmendNo());
		extSys.setMessageType(ext.getMessageType());
		extSys.setModuleCode(ext.getModuleCode());
		extSys.setModuleTag(ext.getModuleTag());
		extSys.setMsgDuplication(ext.getMsgDuplication());
		extSys.setProcessCode(ext.getProcessCode());
		extSys.setProcessTag(ext.getProcessTag());
		extSys.setRecordStatus(ext.getRecordStatus());
		extSys.setReqDirectoryName(ext.getReqDirectoryName());
		extSys.setReqQueueName(ext.getReqQueueName());
		extSys.setReqQueueName(ext.getReqSchemaName());
		extSys.setReqXsltName(ext.getReqXsltName());
		extSys.setRequestTag(ext.getRequestTag());
		extSys.setRespDirectoryName(ext.getRespDirectoryName());
		extSys.setRespQueueName(ext.getRespQueueName());
		extSys.setRespSchemaName(ext.getRespSchemaName());
		extSys.setRespXsltName(ext.getRespXsltName());
		extSys.setResponseTag(ext.getResponseTag());
		extSys.setServiceCode(ext.getServiceCode());
		extSys.setServiceTag(ext.getServiceTag());
		extSys.setUpdatedAt(sqlDate);
		extSys.setVersionNo(extSys.getVersionNo() + 1);
		// System.out.println(extSys);

		extSysRepository.save(extSys);
		// audit
		AuditLog audit = new AuditLog();
		audit.setCreatorId(extSys.getCreatorId());
		audit.setCreatorDtStamp(extSys.getCreatorDtStamp());
		audit.setAction("modification");
		audit.setActionPerformBy(ext.getUpdatedBy());
		audit.setUpdatedAt(sqlDate);
		audit.setRecord(ext.getExtSysCode());
		auditRepo.save(audit);
	}

//	public String sendMail() {
//		MimeMessage message = sender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//
//		try {
//			helper.setTo("prabhatgenji@gmail.com");
//			helper.setText("Greetings :)");
//			helper.setSubject("Mail From Spring Boot 2");
//		} catch (MessagingException e) {
//			e.printStackTrace();
//			return "Error while sending mail ..";
//		}
//
//		return "Mail Sent Success!";
//	}
}

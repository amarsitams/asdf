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
import com.rumango.entity.Tag;
import com.rumango.repo.AuditRepo;
import com.rumango.repo.TagRepo;
@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/tag")
public class TagController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	AuditRepo auditRepo;
	
	@Autowired
	TagRepo tagRepository;
//	@Autowired
//	private RolesRepo rolesRepo;

	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	
	//tagdata
	@GetMapping("/tagdata")
	public List<Tag> getAllTagData() {
		logger.info("Get all tag  data...");
		//System.out.println("Get all Ext tag data...");
 
		List<Tag> tagsdata = new ArrayList<>();
		tagRepository.findAll().forEach(tagsdata::add);
//		tagsdata = tagRepository.fetchAllTags();
//		for(Tag e:tagsdata)
//		{
//			System.err.println(e);
//		}
         // System.out.println(tagsdata);
         // System.out.println(tagsdata);
		return tagsdata;
	}
	
	// create tags
				@PostMapping(value = "/createTag")
				public Tag postTag(@RequestBody Tag entity) {
					logger.info("create a new tag");
					
					
					System.err.println(entity.getNodeForTag());

					AuditLog audit = new AuditLog();
					Date date = new Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					entity.setCreatedDtStamp(sqlDate);
					entity.setCreatorId(entity.getCreatorId());
					//entity.setUpdatedAt(sqlDate);
					entity.setAuthStatus("U");
					entity.setRecordStatus("O");
					entity.setVersionNo(1);
					tagRepository.save(entity);
					
					System.err.println("Tag Object "+entity);
					Tag u = tagRepository.findByTag(entity.getTag());
					//System.out.println(u);   tagRepository.save(entity) != null && 
					if (u == null) {
						tagRepository.save(entity);
						audit.setAction("created");
						audit.setRecord(entity.getTag());
					
						audit.setCreatorId(entity.getCreatorId());// this should be come from creater (logged in user) of new user
						audit.setCreatorDtStamp(sqlDate);
						audit.setUpdatedAt(sqlDate);
						audit.setActionPerformBy(entity.getCreatorId());
						auditRepo.save(audit);
					}
					
					
					logger.info("tag create audit log");
					
					// up.save(user);
					return entity;
				}


//delete user through id
	@DeleteMapping("{tagName}/{userIdLoggedIn}")
	public ResponseEntity<String> deleteUser(@PathVariable("tagName") String tagName, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("inside UserController-deleteUserby userid ");
		AuditLog audit = new AuditLog();
		Tag u = tagRepository.findByTag(tagName);
		logger.info("user status is" + u.getAuthStatus());
		if (u.getAuthStatus().equalsIgnoreCase("U")) {
			logger.info("user is deleted");
			tagRepository.deleteByTag(tagName);
			audit.setAction("deleted");
			audit.setCreatorId(u.getCreatorId());// this should be come from creater (logged in user) of new user
			//audit.setCreatorDtStamp(u.getCreatorDtStamp());
			audit.setActionPerformBy(userIdLoggedIn);
			audit.setUpdatedAt(sqlDate);
			auditRepo.save(audit);
		} else {
			return new ResponseEntity<>("user is authorized you can't delete!", HttpStatus.OK);
		}

		return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
	}

	// verify user
	@GetMapping("/verify/{tagName}/{userIdLoggedIn}")
	public Tag verifyUser(@PathVariable("tagName") String tagName,
			@PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		System.err.println("userIdLoggedIn : " + userIdLoggedIn);
		logger.info("verify method call");
		logger.info("inside UserController-verify user ");
		AuditLog audit = new AuditLog();
		Tag tag = tagRepository.findByTag(tagName);
		tag.setAuthStatus("A");
		tag.setVerifierId(userIdLoggedIn);
		tag.setVerifierDtStamp(sqlDate);
	
		if (tagRepository.save(tag) != null) {
			audit.setAction("verified");
			audit.setActionPerformBy(userIdLoggedIn);
			audit.setRecord(tagName);
			audit.setUpdatedAt(sqlDate);
			audit.setVerifierId(userIdLoggedIn);
			audit.setVerifierDtStamp(sqlDate);
			audit.setCreatorId(tag.getCreatorId());
			//audit.setCreatorDtStamp(tag.getCreatorDtStamp());
			audit.setVerifierId(userIdLoggedIn); // setCreatorId(entity.getUserId());// this should be come from creater
													// (logged in user) of new user
			audit.setVerifierDtStamp(sqlDate); // setUpdatedAt(sqlDate);
			logger.info("user verified log");
			auditRepo.save(audit);



			tagRepository.save(tag);
			logger.info("verify method end");

		} // else ends
		return tag;

	}

// close a record
	@GetMapping("/close/{tagName}/{userIdLoggedIn}")
	public Tag closeRecordUser(@PathVariable("tagName") String tagName, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("verify method call");
		logger.info("inside UserController-closeRecordUser user ");
		AuditLog audit = new AuditLog();
		Tag u = tagRepository.findByTag(tagName);
		System.out.println(u);
		u.setRecordStatus("C");
		tagRepository.save(u);
		//audit
		audit.setCreatorId(u.getCreatorId());
		//audit.setCreatorDtStamp(u.getCreatorDtStamp());
		audit.setAction("user Closed");
		audit.setRecord(tagName);
		audit.setUpdatedAt(sqlDate);
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
		logger.info("closeRecordUser method end");
		return u;
	}

	// re open a record user
	@GetMapping("/reOpen/{tagName}/{userIdLoggedIn}")
	public Tag reopenRecord(@PathVariable("tagName") String tagName, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("verify method call");
		logger.info("inside UserController-reopenRecord user ");
		Tag u = tagRepository.findByTag(tagName);
		System.out.println(u);
		AuditLog audit = new AuditLog();
		u.setRecordStatus("O");
		tagRepository.save(u);
		//audit
		audit.setCreatorId(u.getCreatorId());
		//audit.setCreatorDtStamp(u.getCreatorDtStamp());
		audit.setAction("reopen");
		audit.setRecord(tagName);
		audit.setUpdatedAt(sqlDate);
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
		logger.info("reopenRecord method end");
		return u;
	}

	@GetMapping("/fetchAuthTags")
	public List<Tag> fetchAllAuthRolesController()
	{
		List<Tag> list  = tagRepository.fetchAuthAuthTags();
		
		return list;
	}
	@PutMapping("/modifyTag")
	public void updateUserByIdController(@RequestBody Tag tagEntity) {
		logger.info("update User Id Controller method started");

		Tag tag = tagRepository.findByTag(tagEntity.getTag());
		tag.setErrQueueNameToPick(tagEntity.getErrQueueNameToPick());
		tag.setErrQueueNameToSend(tagEntity.getErrQueueNameToSend());
		tag.setExternalSystemId(tagEntity.getExternalSystemId());
		tag.setLatestAmendNo(tagEntity.getLatestAmendNo());
		tag.setReqQueueNameToPick(tagEntity.getReqQueueNameToPick());
		//tag.setErrQueueNameToSend(tagEntity.getErrQueueNameToSend());
		tag.setReqQueueNameToSend(tagEntity.getReqQueueNameToSend());
		tag.setRespQueueNameToPick(tagEntity.getRespQueueNameToPick());
		tag.setVersionNo(tag.getVersionNo() + 1);
		// preUser.setCreatorDtStamp(sqlDate); //setCreatedAt(sqlDate);
		tag.setUpdatedAt(sqlDate);
		
		//System.out.println(tag);

		tagRepository.save(tag);
		//audit
		AuditLog audit = new AuditLog();
		audit.setCreatorId(tag.getCreatorId());
		//audit.setCreatorDtStamp(preUser.getCreatorDtStamp());
		audit.setAction("modification");
		audit.setActionPerformBy(tag.getCreatorId());
		audit.setRecord(tagEntity.getTag());
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
	}

}

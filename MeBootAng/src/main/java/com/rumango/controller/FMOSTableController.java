package com.rumango.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumango.entity.AuditLog;
import com.rumango.entity.FMOSTableLog;
import com.rumango.repo.AuditRepo;
import com.rumango.repo.FMOSTableLogRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/fmos")
public class FMOSTableController {
private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	//table level maintenance
	@Autowired
	FMOSTableLogRepo fmoscusttxnRepo;
	@Autowired
	AuditRepo auditRepo;
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	
	@PostMapping(value = "/createTableMain")
	public ResponseEntity<Object> postRole(@RequestBody @Valid FMOSTableLog fmosTableLog, BindingResult br) {
		logger.info("inside roleController-postRole ");
		AuditLog audit = new AuditLog();

		FMOSTableLog fmosCustLog = fmoscusttxnRepo.findByApplicationName(fmosTableLog.getApplicationName());
		System.out.println(fmosCustLog);
		if (fmosTableLog != null && fmosCustLog == null) {
			fmosTableLog.setMakerDtStamp(sqlDate);
			fmosTableLog.setRecordStatus("O");
			fmosTableLog.setAuthStatus("U");
			
			fmoscusttxnRepo.save(fmosTableLog);
			 audit.setAction("created");
			 audit.setRecord(fmosTableLog.getApplicationName());
			   audit.setCreatorId(fmosTableLog.getMaker());
			   audit.setCreatorDtStamp(sqlDate);
			   audit.setActionPerformBy(fmosTableLog.getMaker());
			   audit.setUpdatedAt(sqlDate);
			   auditRepo.save(audit);
		}
		return new ResponseEntity<>(fmosCustLog, HttpStatus.OK);
}
	//getCustTranMain
	// get all ext sys
		@GetMapping("/getTableMain")
		public List<FMOSTableLog> getAllExtSys() {
			logger.info("Get all table main  controller data...");
			//System.out.println("Get all Ext Sys data...");
	 
			List<FMOSTableLog> extdata = new ArrayList<>();
			fmoscusttxnRepo.findAll().forEach(extdata::add);
	         // System.out.println(extdata);
			logger.info("all external system data fetching");
			return extdata;
		}
		
}

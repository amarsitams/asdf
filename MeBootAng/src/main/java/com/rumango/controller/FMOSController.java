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
import com.rumango.entity.FMOSCustTxnLog;
import com.rumango.repo.AuditRepo;
import com.rumango.repo.FMOSCustTxnLogRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/fmos")
public class FMOSController {
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	FMOSCustTxnLogRepo fmoscusttxnRepo;
	@Autowired
	AuditRepo auditRepo;
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	
	@PostMapping(value = "/createCustTranMain")
	public ResponseEntity<Object> postRole(@RequestBody @Valid FMOSCustTxnLog fmosCustTranLog, BindingResult br) {
		logger.info("inside roleController-postRole ");
		AuditLog audit = new AuditLog();

		FMOSCustTxnLog fmosCustLog = fmoscusttxnRepo.findByCustomerId(fmosCustTranLog.getCustomerId());
		System.out.println(fmosCustLog);
		if (fmosCustTranLog != null && fmosCustLog == null) {
			fmosCustTranLog.setMakerDtStamp(sqlDate);
			fmosCustTranLog.setRecordStatus("O");
			fmosCustTranLog.setAuthStatus("U");
			
			fmoscusttxnRepo.save(fmosCustTranLog);
			 audit.setAction("created");
			 audit.setRecord(fmosCustTranLog.getCustomerId());
			   audit.setCreatorId(fmosCustTranLog.getCreatorId());
			   audit.setCreatorDtStamp(sqlDate);
			   audit.setActionPerformBy(fmosCustTranLog.getCreatorId());
			   audit.setUpdatedAt(sqlDate);
			   auditRepo.save(audit);
		}
		return new ResponseEntity<>(fmosCustLog, HttpStatus.OK);
}
	//getCustTranMain
	// get all ext sys
		@GetMapping("/getCustTranMain")
		public List<FMOSCustTxnLog> getAllExtSys() {
			logger.info("Get all external system  ext controller data...");
			//System.out.println("Get all Ext Sys data...");
	 
			List<FMOSCustTxnLog> extdata = new ArrayList<>();
			fmoscusttxnRepo.findAll().forEach(extdata::add);
	         // System.out.println(extdata);
			logger.info("all external system data fetching");
			return extdata;
		}
		
}
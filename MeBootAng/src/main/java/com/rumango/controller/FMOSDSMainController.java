package com.rumango.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumango.repo.AuditRepo;
import com.rumango.repo.FMOSEmpLogRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/fmos")
public class FMOSDSMainController {
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	//App User  maintenance
	@Autowired
	FMOSEmpLogRepo fmoscusttxnRepo;
	@Autowired
	AuditRepo auditRepo;
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	
//	@PostMapping(value = "/createAppUserMain")
//	public ResponseEntity<Object> postRole(@RequestBody @Valid FMOSEmpLog fmosTableLog, BindingResult br) {
//		logger.info("inside roleController-postRole ");
//		AuditLog audit = new AuditLog();
//
//		FMOSEmpLog fmosCustLog = fmoscusttxnRepo.findByApplicationUserId(fmosTableLog.getApplicationUserId());
//		System.out.println(fmosCustLog);
//		if (fmosTableLog != null && fmosCustLog == null) {
//			fmosTableLog.setMakerDtStamp(sqlDate);
//			fmosTableLog.setRecordStatus("O");
//			fmosTableLog.setAuthStatus("U");
//			
//			fmoscusttxnRepo.save(fmosTableLog);
//			 audit.setAction("created");
//			 audit.setRecord(fmosTableLog.getApplicationUserId());
//			   audit.setCreatorId(fmosTableLog.getMaker());
//			   audit.setCreatorDtStamp(sqlDate);
//			   audit.setActionPerformBy(fmosTableLog.getCreatorId() );
//			   audit.setUpdatedAt(sqlDate);
//			   auditRepo.save(audit);
//		}
//		return new ResponseEntity<>(fmosCustLog, HttpStatus.OK);
//}
//	//getCustTranMain
//	// get all ext sys
//		@GetMapping("/getAllAppUser")
//		public List<FMOSEmpLog> getAllExtSys() {
//			logger.info("Get all table main  controller data...");
//			//System.out.println("Get all Ext Sys data...");
//	 
//			List<FMOSEmpLog> extdata = new ArrayList<>();
//			fmoscusttxnRepo.findAll().forEach(extdata::add);
//	         // System.out.println(extdata);
//			logger.info("all external system data fetching");
//			return extdata;
//		}
		
}

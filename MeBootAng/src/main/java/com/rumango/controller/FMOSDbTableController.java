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
import com.rumango.entity.FMOSDbTable;
import com.rumango.repo.AuditRepo;
import com.rumango.repo.FMOSDbTableRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/fmos")
public class FMOSDbTableController {
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	// db level maintenance
	@Autowired
	FMOSDbTableRepo fmosDbTable;
	@Autowired
	AuditRepo auditRepo;
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	@PostMapping(value = "/createDbLevel")
	public ResponseEntity<Object> postRole(@RequestBody @Valid FMOSDbTable dbTableRepo, BindingResult br) {
		logger.info("inside FMOS Screen-postRole ");
		AuditLog audit = new AuditLog();

		FMOSDbTable fmosTableLog = fmosDbTable.findByUserName(dbTableRepo.getUserName());
		logger.info("ueo " + dbTableRepo.toString());
		if (dbTableRepo != null && fmosTableLog == null) {
			dbTableRepo.setMakerDtStamp(sqlDate);
			dbTableRepo.setRecordStatus("O");
			dbTableRepo.setAuthStatus("U");

			fmosDbTable.save(dbTableRepo);
			audit.setAction("created");
			audit.setRecord(dbTableRepo.getUserName());
			audit.setCreatorId(dbTableRepo.getMaker());
			audit.setCreatorDtStamp(sqlDate);
			audit.setActionPerformBy(dbTableRepo.getMaker());
			audit.setUpdatedAt(sqlDate);
			auditRepo.save(audit);
		}
		return new ResponseEntity<>(dbTableRepo, HttpStatus.OK);
	}

	// getCustTranMain
	// get all ext sys
	@GetMapping("/getAllDbLevelData")
	public List<FMOSDbTable> getAllExtSys() {
		logger.info("Get all db table log  controller data...");
		// System.out.println("Get all Ext Sys data...");

		List<FMOSDbTable> extdata = new ArrayList<>();
		fmosDbTable.findAll().forEach(extdata::add);
		// System.out.println(extdata);
		logger.info("all external system data fetching");
		return extdata;
	}

}

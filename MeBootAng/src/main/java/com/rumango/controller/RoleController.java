package com.rumango.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.rumango.entity.RolesEntity;
import com.rumango.repo.AuditRepo;
import com.rumango.repo.RolesRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/role")
public class RoleController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	RolesRepo roleRepository;
	@Autowired
	AuditRepo auditRepo;
	Map<String, String> errors;
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	@PostMapping(value = "/createRole")
	public ResponseEntity<Object> postRole(@RequestBody @Valid RolesEntity roleEntity, BindingResult br) {
		logger.info("inside roleController-postRole ");
		//System.out.println(roleEntity);
		//RolesEntity role = roleRepository.findByRoleName(roleEntity.getRoleName());
		AuditLog audit = new AuditLog();
		//roleEntity.setMaker(maker);
		
		
		RolesEntity u = roleRepository.findByRoleName(roleEntity.getRoleName());
		System.out.println(u);
		if (roleEntity != null && u == null) {
			roleEntity.setMakerDtStamp(sqlDate);
			roleEntity.setRecordStatus("O");
			roleEntity.setAuthStatus("U");
			
			roleRepository.save(roleEntity);
			 audit.setAction("created");
			 audit.setRecord(roleEntity.getRoleName());
			   audit.setCreatorId(roleEntity.getMaker());
			   audit.setCreatorDtStamp(sqlDate);
			   audit.setActionPerformBy(roleEntity.getMaker());
			   audit.setUpdatedAt(sqlDate);
			   auditRepo.save(audit);
		}
  
//		if (br.hasErrors()) {
//			errors = new HashMap<>();
//			for (FieldError error : br.getFieldErrors()) {
//				errors.put(error.getField(), error.getDefaultMessage());
//			}
//			return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
//		}
//		logger.info("inside create role");
//
//		if (_roleEntity != null) {
//			return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
//		}
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

// get one role
	@GetMapping(value = "/{roleName}")
	public RolesEntity findByRoleId(@PathVariable String roleName) {
		System.out.println(roleName);
		System.out.println("get one role");
		RolesEntity role = roleRepository.findByRoleName(roleName);
		System.out.println(role);
		return role;
	}

// get all roles
	
	@GetMapping("/roles")
	public List<RolesEntity> getAllRoless() {
		System.out.println("Get all Roles...");

		List<RolesEntity> roles = new ArrayList<>();
		roleRepository.findAll().forEach(roles::add);
System.out.println(roles);
		return roles;
	}

//delete role through id
	@DeleteMapping("{roleName}/{userIdLoggedIn}")
	public ResponseEntity<String> deleteRole(@PathVariable("roleName") String roleName, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("inside UserController-deleterole by id ");
		AuditLog audit = new AuditLog();
		RolesEntity role = roleRepository.findByRoleName(roleName);
		logger.info("user status is" + role.getAuthStatus());
		if (role.getAuthStatus().equalsIgnoreCase("U")) {
			logger.info("user is deleted");
			roleRepository.deleteByRoleName(roleName);
			audit.setAction("deleted");
			audit.setRecord(roleName);
			audit.setActionPerformBy(userIdLoggedIn);
			audit.setUpdatedAt(sqlDate);
			auditRepo.save(audit);
//			 audit.setVerifierDtStamp(sqlDate);
//			 audit.setVerifierId(userId);
//			 audit.setCreatedAt(u.getCreatedAt());
//			 audit.setCreatorDtStamp(u.getCreatorDtStamp());
//			 audit.setCreatorId(userId);// this should be come from creater (logged in
//			 user) of new user
//			 audit.setUpdatedAt(sqlDate);
		} else {
			return new ResponseEntity<>("role has authorized!", HttpStatus.OK);
		}

		return new ResponseEntity<>("role has been deleted!", HttpStatus.OK);
	}

	// verify ROLE
	@GetMapping("/{roleName}/{userIdLoggedIn}")
	public RolesEntity verifyRole(@PathVariable("roleName") String roleName, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("verify method call");
		logger.info("inside RoleController-verify role ");
		AuditLog audit = new AuditLog();
		RolesEntity role = roleRepository.findByRoleName(roleName);

		audit.setVerifierId(role.getMaker()); // setCreatorId(entity.getUserId());// this should be come from creater
												// (logged in user) of new user
		//audit.setVerifierDtStamp(sqlDate);
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setAction("verified role");
		audit.setUpdatedAt(sqlDate);
		audit.setRecord(roleName);
		audit.setCreatorId(role.getMaker());
		
		role.setAuthStatus("A");
		role.setVerifierId(userIdLoggedIn);
		role.setCheckerDtStamp(sqlDate);
		roleRepository.save(role);
		auditRepo.save(audit);
		logger.info("verify method end");
		return role;
	} // else ends

//close a ROLE
	@GetMapping("/close/{roleName}/{userIdLoggedIn}")
	public RolesEntity closeRecordUser(@PathVariable("roleName") String roleName, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("verify method call");
		logger.info("inside UserController-closeRecordUser user ");
		RolesEntity role = roleRepository.findByRoleName(roleName);
		AuditLog audit = new AuditLog();
		role.setRecordStatus("C");
		roleRepository.save(role);
		
		audit.setAction("close role");
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setRecord(roleName);
		audit.setUpdatedAt(sqlDate);
		audit.setCreatorId(role.getMaker());
		auditRepo.save(audit);
		logger.info("closeRecordUser method end");
		return role;
	}

	// re open a ROLE
	@GetMapping("/reOpen/{roleName}/{userIdLoggedIn}")
	public RolesEntity reopenRecord(@PathVariable("roleName") String roleName, @PathVariable("userIdLoggedIn") String userIdLoggedIn) {
		logger.info("verify method call");
		logger.info("inside RoleController-reopenRecord role ");
		RolesEntity role = roleRepository.findByRoleName(roleName);
		AuditLog audit = new AuditLog();
		role.setRecordStatus("O");
		roleRepository.save(role);
		
		audit.setAction("reopen");
		audit.setActionPerformBy(userIdLoggedIn);
		audit.setRecord(roleName);
		audit.setUpdatedAt(sqlDate);
		audit.setCreatorId(role.getMaker());
		auditRepo.save(audit);
		logger.info("reopenRecord method end");
		return role;
	}
// modify roles
	@PutMapping("/modifyRole")
	public void updateUserByIdController(@RequestBody RolesEntity roleEntity) {
		logger.info("update Role Controller method started");

		RolesEntity role = roleRepository.findByRoleName(roleEntity.getRoleName());
		role.setAuth1(roleEntity.getAuth1());
		role.setAuth2(roleEntity.getAuth2());
		role.setAuth3(roleEntity.getAuth3());
		role.setAuth4(roleEntity.getAuth4());
		role.setClose1(roleEntity.getClose1());
		role.setClose2(roleEntity.getClose2());
		role.setClose3(roleEntity.getClose3());
		role.setClose4(roleEntity.getClose4());
		role.setCopy1(roleEntity.getCopy1());
		role.setCopy2(roleEntity.getCopy2());
		role.setCopy3(roleEntity.getCopy3());
		role.setCopy4(roleEntity.getCopy4());
		role.setDelete1(roleEntity.getDelete1());
		role.setDelete2(roleEntity.getDelete2());
		role.setDelete3(roleEntity.getDelete3());
		role.setDelete4(roleEntity.getDelete4());
		role.setNew1(roleEntity.getNew1());
		role.setNew2(roleEntity.getNew2());
		role.setNew3(roleEntity.getNew3());
		role.setNew4(roleEntity.getNew4());
		role.setPrint1(roleEntity.getPrint1());
		role.setPrint2(roleEntity.getPrint2());
		role.setPrint3(roleEntity.getPrint3());
		role.setPrint4(roleEntity.getPrint4());
		role.setReopen1(roleEntity.getReopen1());
		role.setReopen2(roleEntity.getReopen2());
		role.setReopen3(roleEntity.getReopen3());
		role.setReopen4(roleEntity.getReopen4());
		role.setUnlock1(roleEntity.getUnlock1());
		role.setUnlock2(roleEntity.getUnlock2());
		role.setUnlock3(roleEntity.getUnlock3());
		role.setUnlock4(roleEntity.getUnlock4());
		role.setView1(roleEntity.getView1());
		role.setView2(roleEntity.getView2());
		role.setView3(roleEntity.getView3());
		role.setView4(roleEntity.getView4());
		role.setRoleDesc(roleEntity.getRoleDesc());
		role.setVersionNo(role.getVersionNo() + 1);
		// preUser.setCreatorDtStamp(sqlDate); //setCreatedAt(sqlDate);
		role.setUpdatedAt(sqlDate);
		//System.out.println(role);

		roleRepository.save(role);
		//audit
		AuditLog audit = new AuditLog();
		audit.setCreatorId(role.getMaker());
		audit.setCreatorDtStamp(role.getMakerDtStamp());
		audit.setAction("modification");
		audit.setActionPerformBy(role.getMaker());
		audit.setRecord(roleEntity.getRoleName());
		audit.setUpdatedAt(sqlDate);
		auditRepo.save(audit);
	}
	
	@GetMapping("/fetchAuthRoles")
	public List<RolesEntity> fetchAllAuthRolesController()
	{
		List<RolesEntity> list  = roleRepository.fetchAuthRoles();
		
		return list;
	}
}

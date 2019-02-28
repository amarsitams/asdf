package com.rumango.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumango.entity.FMOSEmpLog;

public interface FMOSEmpLogRepo extends JpaRepository<FMOSEmpLog, Long>{
	@Transactional
	FMOSEmpLog findByApplicationUserId(String fmosCustTranLog);
}

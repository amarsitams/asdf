package com.rumango.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumango.entity.FMOSCustTxnLog;

public interface FMOSCustTxnLogRepo extends JpaRepository<FMOSCustTxnLog, Long>{
	@Transactional
	FMOSCustTxnLog findByCustomerId(String fmosCustTranLog);
}

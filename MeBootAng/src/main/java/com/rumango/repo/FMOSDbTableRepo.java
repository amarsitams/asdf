package com.rumango.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumango.entity.FMOSDbTable;

public interface FMOSDbTableRepo extends JpaRepository<FMOSDbTable, Long>{
	@Transactional
	FMOSDbTable findByUserName(String fmosCustTranLog);
}

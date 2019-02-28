package com.rumango.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumango.entity.FMOSTableLog;

public interface FMOSTableLogRepo extends JpaRepository<FMOSTableLog, Long>{
	FMOSTableLog findByApplicationName(String fmosTableLog);
}

package com.rumango.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rumango.entity.ExternalSystem;

public interface ExtSysRepo extends JpaRepository<ExternalSystem, Long>{

	//ExternalSystem findByExtSysName(String extSysName);
	@Transactional
	void deleteByExtSysName(String extSysName);

	@Transactional
	void deleteById(Long extSysName);
	
	@Transactional
	ExternalSystem findByExtSysName(String extSysName);
	
	@Query("from ExternalSystem where authStatus = 'A'")
	public List<ExternalSystem> fetchAuthAuthExtSystem();
	@Query("from ExternalSystem where extSysCode = :extSysCode")
	public ExternalSystem fetchExt(@Param("extSysCode")String extSysCode);
}

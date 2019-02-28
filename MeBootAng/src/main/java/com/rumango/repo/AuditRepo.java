package com.rumango.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumango.entity.AuditLog;

public interface AuditRepo extends JpaRepository<AuditLog, Long>{

}

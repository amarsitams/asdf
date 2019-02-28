package com.rumango.repo;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rumango.entity.User;

public interface UserRepo extends JpaRepository<User, String> {
	//List<User> findByUserId(String userId);

	// @Query(value = "SELECT t FROM User t WHERE userId=:userId")
	// RolesEntity findCustom(String userId);

	// @Query(value = "DELETE * FROM User t WHERE userId=?1")
	@Transactional
	void deleteByUserId(String userId);

	@Transactional
	void deleteById(Long userId);
	
	@Transactional
	User findByUserId(String userId);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update User set logoutTime=:logoutTime where userId=:userId")
	public int updateLastLogin(@Param("logoutTime")Timestamp logoutTime,@Param("userId")String userId);
	
}

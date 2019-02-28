package com.rumango.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rumango.entity.RolesEntity;

@Repository
public interface RolesRepo extends CrudRepository<RolesEntity, String> {
	RolesEntity findByRoleName(String roleName);
	
//	@Query(value="SELECT t FROM RolesEntity t WHERE roleName=:roleName")
//	RolesEntity findCustom(String roleName);
//	
//
//	default RolesEntity getOne(String roleName) {
//		return findByRoleName(roleName);
//	}
	
	@Transactional
	void deleteByRoleName(String roleName);

	@Transactional
	void deleteById(Long roleName);
	
	@Query("from RolesEntity where authStatus = 'A'")
	public List<RolesEntity> fetchAuthRoles();
	
//	@Transactional
//	User findByUserId(String userId);
}

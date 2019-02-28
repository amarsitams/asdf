package com.rumango.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rumango.entity.Tag;

public interface TagRepo extends JpaRepository<Tag, Long>{
	@Transactional
	void deleteByTag(String tagName);

	@Transactional
	void deleteById(Long id);
	
	@Transactional
	Tag findByTag(String tagName);
	
	@Query("from Tag")
	public List<Tag> fetchAllTags();
	@Query("from Tag where authStatus = 'A'")
	public List<Tag> fetchAuthAuthTags();
	
	@Query("from Tag where externalSystemId = :externalSystemId")
	public Tag fetchTagOnExt(@Param("externalSystemId")String externalSystemId);
}

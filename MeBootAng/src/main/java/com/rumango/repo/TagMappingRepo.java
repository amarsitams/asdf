package com.rumango.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumango.entity.TagMappingClass;

public interface TagMappingRepo extends JpaRepository<TagMappingClass, Long> {

}

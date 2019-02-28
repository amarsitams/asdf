package com.rumango.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumango.entity.ExternalSystem;
import com.rumango.entity.Tag;
import com.rumango.entity.TagMapping;
import com.rumango.entity.TagMappingClass;
import com.rumango.repo.ExtSysRepo;
import com.rumango.repo.TagMappingRepo;
import com.rumango.repo.TagRepo;

@CrossOrigin(origins = "*")
@RequestMapping ("/tagMapping")
@RestController
public class TagMappingController {
	private final static Logger logger = LoggerFactory.getLogger(TagMappingController.class);
	
	@Autowired
	TagRepo tagRepository;
	@Autowired
	ExtSysRepo extSysRepository;
	
	@Autowired
	TagMappingRepo tagMappingRepo;
	
	//create tag mapping 
	@PostMapping(value = "/getNode")
	public List postTag(@RequestBody TagMapping entity) {
		logger.info("getting node based on extsys");
		System.out.println(entity.getExtSysCode1());
		System.out.println(entity.getExtSysCode2());
		 Tag t1=tagRepository.fetchTagOnExt(entity.getExtSysCode1());
		 Tag t2=tagRepository.fetchTagOnExt(entity.getExtSysCode2());
		 ExternalSystem ext1=extSysRepository.fetchExt(entity.getExtSysCode1());
		 ExternalSystem ext2=extSysRepository.fetchExt(entity.getExtSysCode2());
		 System.out.println(t1);
		 System.out.println(t2);
		 List listOfValues= new ArrayList();
		 listOfValues.add(t1);
		 listOfValues.add(t2);
//		 listOfValues.add(ext1);
//		 listOfValues.add(ext2);
		return listOfValues;
	}
	//tag mapping
	@PostMapping(value = "/postTagMapping")
	public void postTagMapping(@RequestBody List<TagMappingClass> entity) {
		logger.info("post tag mapping call");
		tagMappingRepo.saveAll(entity);
	}
}

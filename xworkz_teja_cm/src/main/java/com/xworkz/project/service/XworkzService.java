package com.xworkz.project.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.project.dto.XworkzDto;

public interface XworkzService {

	Set<ConstraintViolation<XworkzDto>> validateAndsave(XworkzDto dto);
	
	default List<XworkzDto> findAll(){
		return Collections.emptyList();
	}
	
	boolean  sendMail(String to);
}

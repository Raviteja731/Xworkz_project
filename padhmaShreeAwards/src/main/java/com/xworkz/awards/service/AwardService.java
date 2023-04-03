package com.xworkz.awards.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.awards.dto.AwardDTO;
import com.xworkz.awards.entity.AwardEntity;

public interface AwardService {

	Set<ConstraintViolation<AwardDTO>> validateAndSave(AwardDTO dto);
	
	 AwardDTO findby(int id) ;
	 
	 default List<AwardDTO> findAwardName(String awardName){
		return Collections.emptyList();
	 }
	
	Set<ConstraintViolation<AwardDTO>> validateAndUpdate(AwardDTO awardDTO);
	
	default boolean validateAndDelete(int id) {
		return false;
	}
}

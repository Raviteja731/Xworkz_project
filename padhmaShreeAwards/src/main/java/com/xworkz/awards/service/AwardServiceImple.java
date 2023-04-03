package com.xworkz.awards.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.awards.dto.AwardDTO;
import com.xworkz.awards.entity.AwardEntity;
import com.xworkz.awards.repository.AwardRepository;

@Service
public class AwardServiceImple implements AwardService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AwardRepository awardRepository;

	public AwardServiceImple() {
		log.info("Running AwardServiceImple...");
	}

	@Override
	public Set<ConstraintViolation<AwardDTO>> validateAndSave(AwardDTO dto) {
		log.info("Running validateAndSave...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<AwardDTO>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			log.info("violations in dto " + dto);

			return violations;
		}
		log.info("violations not found");
		AwardEntity entity = new AwardEntity();
		log.info("dto",dto);
		
		BeanUtils.copyProperties(dto, entity);
		log.info("entity",entity);
		
		boolean saved = this.awardRepository.save(entity);
		log.info("Entity is Saved :" + saved);
		return Collections.emptySet();
	}

	@Override
	public AwardDTO findby(int id) {
		log.info("Running findbyId in ServiceImple..."+id);
		if (id > 0) {
			AwardEntity awardEntity = awardRepository.findBy(id);
			log.info("AwardEntity ",awardEntity);
			log.info("Entity is found in service for id" + id);
			AwardDTO dto = new AwardDTO();
			
			BeanUtils.copyProperties(awardEntity, dto);
			
			return dto;
		}
		return null;
	}

	 @Override
	public List<AwardDTO> findAwardName(String awardName) {
			log.info("Running findAwardName...");
			List<AwardEntity> list = awardRepository.findByAwardName(awardName);
			if (list!= null&& !list.isEmpty()) {
				
				List<AwardDTO>  awardDTOs = new ArrayList<AwardDTO>();
				
				for (AwardEntity awardEntity : list) {
				
					AwardDTO dto = new AwardDTO();
					
				BeanUtils.copyProperties(awardEntity, dto);
					
					awardDTOs.add(dto);
				}
				return awardDTOs;
			} else {
				System.err.println("awardDTOs is null");
				return AwardService.super.findAwardName(awardName);
			}
		
	}
	
	 
	@Override
	public Set<ConstraintViolation<AwardDTO>> validateAndUpdate(AwardDTO awardDTO) {
		log.info("awardDTOs validateAndUpdate");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<AwardDTO>> violations = validator.validate(awardDTO);
		if(!violations.isEmpty()) {
			log.info("Violation founded");
			return violations;
		}else {
			log.info("violations is not found");
			AwardEntity entity = new AwardEntity();
			
			BeanUtils.copyProperties(awardDTO, entity);
			
			
		boolean saved=	this.awardRepository.update(entity);
			log.info("Entity is Saved :" + saved);
			return Collections.emptySet();

		}
		
	}

	@Override
	public boolean validateAndDelete(int id) {
	log.info("Running validateAndDelete");
	if(id<0) {
		return false;
	}else {
	boolean deleted=	this.awardRepository.delete(id);
		log.info("deleted :"+deleted);
		return deleted;
	}
}
}

package com.xworkz.awards.repository;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.xworkz.awards.entity.AwardEntity;

public interface AwardRepository {

	
	
	boolean save(AwardEntity awardEntity);

	AwardEntity findBy(int id);

	default List<AwardEntity> findByAwardName(String AwardName) {
		return Collections.emptyList();
	}

	default List<AwardEntity> findbyGivenBy(String GivenBy) {
		return Collections.emptyList();
	}

	default Set<AwardEntity> update(int id) {

		return Collections.emptySet();
	}
	
	boolean update(AwardEntity awardEntity);
	
	boolean delete(int id);
}

package com.xworkz.project.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.project.entity.XworkzEntity;

public interface XworkzRepository {

	boolean save(XworkzEntity xworkzEntity);
	
	default List<XworkzEntity> findAll(){
		return Collections.emptyList();
	}
}

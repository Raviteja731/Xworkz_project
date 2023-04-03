package com.xworkz.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.project.entity.XworkzEntity;

@Repository
public class XworkzRepoImple implements XworkzRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public XworkzRepoImple() {
		System.out.println("Created XworkzRepoImple in RepoImple...." + getClass().getSimpleName());
	}

	@Override
	public boolean save(XworkzEntity xworkzEntity) {
		System.out.println("Running save in RepoImple....");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(xworkzEntity);
		entityTransaction.commit();
		entityManager.close();
		return true;
	}

	@Override
	public List<XworkzEntity> findAll() {
		System.out.println("Running findAll in RepoImple....");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	  try {
			Query query = entityManager.createNamedQuery("find");
			List<XworkzEntity> list = query.getResultList();
			System.out.println("total Size is :"+list.size());
			return list;
		}finally {
			entityManager.close();
		}
		
	}

}

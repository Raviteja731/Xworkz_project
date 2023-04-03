package com.xworkz.awards.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.awards.entity.AwardEntity;

@Repository
public class AwardRepoImple implements AwardRepository {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public AwardRepoImple() {
		log.info("Running AwardRepoImple.." + getClass().getSimpleName());
		
	}

	@Override
	public boolean save(AwardEntity awardEntity) {
		log.info("Running save..");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(awardEntity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public AwardEntity findBy(int id) {

		log.info("Running findBy in RepoImple..."+id);
		EntityManager manager = entityManagerFactory.createEntityManager();
		AwardEntity entity = manager.find(AwardEntity.class, id);
		manager.close();

		return entity;
	}

	@Override
	public List<AwardEntity> findByAwardName(String AwardName) {
		log.info("Running findByAwardName in repoImpl...");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
		Query query = entityManager.createNamedQuery("findByAwardName");
		query.setParameter("by", AwardName);
		List<AwardEntity> list = query.getResultList();
		if (AwardName != null && !list.isEmpty()) {
			log.info("list",list.size());
			return list;
		}
		}
		finally {
			entityManager.close();
		}
		return AwardRepository.super.findByAwardName(AwardName);
	}

	@Override
	public boolean update(AwardEntity awardEntity) {
		log.info("Running update");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.merge(awardEntity);
	entityTransaction.commit();
	return true;
		}finally {
			entityManager.close();
		}
	}

	@Override
	public boolean delete(int id) {
		log.info("Running delete");
	EntityManager entityManager=	entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=	entityManager.getTransaction();
AwardEntity awardEntity = entityManager.find(AwardEntity.class, id);
entityTransaction.begin();
entityManager.remove(awardEntity);
entityTransaction.commit();
entityManager.close();
		return true;
	}

	
	
}

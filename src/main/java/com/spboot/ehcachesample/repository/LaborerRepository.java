package com.spboot.ehcachesample.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spboot.ehcachesample.entity.Laborer;

@Repository
@Transactional
public class LaborerRepository {

	@Autowired
	EntityManager entityManager;

	public Laborer findById(Long id) {
		return entityManager.find(Laborer.class, id);
	}

	public Laborer save(Laborer laborer) {
		if (laborer.getId() == null) {
			entityManager.persist(laborer);
		} else {
			entityManager.merge(laborer);
		}
		return laborer;
	}

	public void deleteById(Long id) {
		Laborer laborer = findById(id);
		entityManager.remove(laborer);
	}
	
}

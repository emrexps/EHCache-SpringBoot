package com.spboot.ehcachesample.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spboot.ehcachesample.entity.Department;
import com.spboot.ehcachesample.entity.Laborer;

@Repository
@Transactional
public class DepartmentRepository {

	@Autowired
	EntityManager entityManager;

	public Department findById(Long id) {
		return entityManager.find(Department.class, id);
	}

	public Department save(Department department) {
		if (department.getId() == null) {
			entityManager.persist(department);
		} else {
			entityManager.merge(department);
		}
		return department;
	}

	public void deleteById(Long id) {
		Department department = findById(id);
		entityManager.remove(department);
	}
}

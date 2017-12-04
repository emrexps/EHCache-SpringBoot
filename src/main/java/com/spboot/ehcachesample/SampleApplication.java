package com.spboot.ehcachesample;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spboot.ehcachesample.entity.Department;
import com.spboot.ehcachesample.entity.Laborer;
import com.spboot.ehcachesample.entity.Manager;
import com.spboot.ehcachesample.repository.DepartmentRepository;
import com.spboot.ehcachesample.repository.LaborerRepository;
import com.spboot.ehcachesample.repository.ManagerRepository;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	LaborerRepository laborerRepository;

	@Autowired
	DepartmentRepository departmentRepository;


	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Department dep1 = new Department("Software");
		Department dep2 = new Department("Marketing");

		logger.info("Added  Manageer ->{}",
				managerRepository.save(new Manager("Emre", "Eker", BigDecimal.valueOf(3000), dep1)));

		logger.info("Added  Manageer ->{}",
				managerRepository.save(new Manager("Cemre", "Eker", BigDecimal.valueOf(4000), dep2)));

		logger.info("Added  Laborer ->{}",
				laborerRepository.save(new Laborer("John", "Smit", BigDecimal.valueOf(2000), 2, dep1)));
		logger.info("Added  Laborer ->{}",
				laborerRepository.save(new Laborer("Michael", "Carlson", BigDecimal.valueOf(3000), 3, dep1)));

		managerRepository.deleteById(Long.valueOf(1));

		logger.info("Added  Manageer ->{}",
				managerRepository.save(new Manager("İsmail", "Eker", BigDecimal.valueOf(3000), dep1)));

		dep1.setDept_name("Computer Hardware");
		
		laborerRepository.deleteById(Long.valueOf(5));

		managerRepository.deleteById(Long.valueOf(7));
		logger.info("Get from cache ->{}",departmentRepository.findById(Long.valueOf(4)));
		logger.info("Get from cache ->{}",departmentRepository.findById(Long.valueOf(2)));
		logger.info("Get from cache ->{}",departmentRepository.findById(Long.valueOf(4)));

	}
}

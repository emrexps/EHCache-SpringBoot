package com.spboot.ehcachesample.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Laborer extends Employee{
	
	private BigDecimal salary;
	private int level;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	Department department;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Laborer() {
	}

	public Laborer(String name,String surname, BigDecimal salary,int level, Department dep1) {
		super(name,surname);
		this.salary = salary;
		this.level=level;
		this.department=dep1;
	}

}

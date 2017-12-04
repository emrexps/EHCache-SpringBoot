package com.spboot.ehcachesample.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Manager extends Employee{
	
	private BigDecimal salary;
	
/*	@JoinColumn(name = "deparment_id")*/
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	@JoinTable(name = "dept_managers", 
	joinColumns = @JoinColumn(name = "MANAGER_ID"), 
	inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID"))
	private Department department;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Manager() {
	}

	public Manager(String name,String surname, BigDecimal salary,Department department ) {
		super(name,surname);
		this.salary = salary;
		this.department=department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}

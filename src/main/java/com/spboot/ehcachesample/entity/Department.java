package com.spboot.ehcachesample.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Cacheable
public class Department {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String dept_name;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="department")
	private Manager manager;
	
	@OneToMany(mappedBy="department")
	private List<Laborer> laborer=new ArrayList<>();

	public Department() {}
	
	public Department( String dept_name) {
		super();
		this.dept_name = dept_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Long getId() {
		return id;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	

	public List<Laborer> getLaborer() {
		return laborer;
	}

	public void addLaborer(Laborer laborer) {
		this.laborer.add(laborer);
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", dept_name=" + dept_name + "]";
	}
	
}
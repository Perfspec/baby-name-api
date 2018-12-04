package com.infosys.babynameapi.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Baby {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer desiredNameLength;
	private String name;
	
	public Baby() {}
	
	public Baby(Integer length, String name){
		this.desiredNameLength=length;
		this.name = name;
	}
	
	public void become(Baby newBaby) {
		this.name=newBaby.getName();
		this.desiredNameLength=newBaby.getDesiredNameLength();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDesiredNameLength() {
		return desiredNameLength;
	}

	public void setDesiredNameLength(Integer desiredNameLength) {
		this.desiredNameLength=desiredNameLength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

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
		if(length > 12) {
			this.desiredNameLength=12;
		} else {
			this.desiredNameLength=length;
		}
		this.name = name;
	}
	
	public void become(Baby newBaby) {
		this.name=newBaby.getName();
		int newLength=newBaby.getDesiredNameLength();
		if(newLength > 12) {
			this.desiredNameLength=12;
		} else if (newLength < 2) {
			this.desiredNameLength=2;
		} else {
			this.desiredNameLength=newLength;
		}
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
		if(desiredNameLength > 12) {
			this.desiredNameLength=12;
		} else if (desiredNameLength < 2) {
			this.desiredNameLength=2;
		} else {
			this.desiredNameLength=desiredNameLength;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

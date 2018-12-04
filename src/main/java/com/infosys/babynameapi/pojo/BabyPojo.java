package com.infosys.babynameapi.pojo;

import com.infosys.babynameapi.persistence.domain.Baby;

public class BabyPojo {
	
	private Long id;
	private Integer desiredNameLength;
	private String name;
	
	public BabyPojo() {}
	
	public BabyPojo(Long id,
			Integer length,
			String name){
		this.id=id;
		this.desiredNameLength=length;
		this.name = name;
	}
	
	public BabyPojo(Baby baby){
		this.id=baby.getId();
		this.desiredNameLength=baby.getDesiredNameLength();
		this.name = baby.getName();
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
		this.desiredNameLength = desiredNameLength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

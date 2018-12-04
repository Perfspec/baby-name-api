package com.infosys.babynameapi.business.service;

import java.util.Optional;

import com.infosys.babynameapi.persistence.domain.Baby;

public interface IBabyService {

	Iterable<Baby> getAll();

	Optional<Baby> find(Long id);

	Baby create(Baby baby);
	
	String delete(Long id);

	String update(Long id, Baby baby);
}

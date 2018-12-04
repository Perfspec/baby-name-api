package com.infosys.babynameapi.rest;

import java.util.Optional;

import com.infosys.babynameapi.persistence.domain.Baby;

public interface IBabyEndpoint {
	Iterable<Baby> getAll();
	
	Baby create(Baby baby);

	Optional<Baby> find(Long id);
	
	String delete(Long id);

	String update(Long id, Baby baby);
}

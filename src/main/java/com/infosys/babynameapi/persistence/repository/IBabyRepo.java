package com.infosys.babynameapi.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.babynameapi.persistence.domain.Baby;

@Repository
public interface IBabyRepo extends CrudRepository<Baby, Long> {}

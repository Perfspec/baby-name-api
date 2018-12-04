package com.infosys.babynameapi.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.infosys.babynameapi.persistence.domain.Baby;
import com.infosys.babynameapi.persistence.repository.IBabyRepo;
import com.infosys.babynameapi.webservice.IConsumeBabyNames;

@Service
public class BabyService implements IBabyService {
	
	@Value("${deleted_baby_msg}")
	private String deletedBabyMsg;
	
	@Value("${updated_baby_msg}")
	private String updatedBabyMsg;
	
	@Value("${baby_not_found_msg}")
	private String babyNotFoundMsg;
	
	@Autowired
	private IBabyRepo repo;
	
	@Autowired
	private IConsumeBabyNames consumer;

	public Iterable<Baby> getAll() {
		return repo.findAll();
	}

	public Optional<Baby> find(Long id) {
		return repo.findById(id);
	}

	public Baby create(Baby baby) {
		baby.setName(consumer.selectNameFor(baby));
		return repo.save(baby);
	}

	public String delete(Long id) {
		boolean babyExists = repo.findById(id) != null;
		if(babyExists) {
			repo.deleteById(id);
			return deletedBabyMsg;
		}
		return babyNotFoundMsg;
	}

	public String update(Long id, Baby newBaby) {
		boolean babyExists = repo.findById(id) != null;
		if(babyExists) {
			Baby oldBaby = repo.findById(id).get();
			oldBaby.become(newBaby);
			repo.save(oldBaby);
			return updatedBabyMsg;
		}
		return babyNotFoundMsg;
	}

}

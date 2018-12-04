package com.infosys.babynameapi.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.babynameapi.business.service.IBabyService;
import com.infosys.babynameapi.persistence.domain.Baby;

@RequestMapping("${base_endpoint}")
@RestController
@CrossOrigin
public class BabyEndpoint implements IBabyEndpoint {
	
	@Autowired
	private IBabyService service;
	
	@GetMapping("${getall_endpoint}")
	public Iterable<Baby> getAll() {
		return service.getAll();
	}

	@GetMapping("${get_endpoint}")
	public Optional<Baby> find(@PathVariable Long id) {
		return service.find(id);
	}

	@PostMapping("${create_endpoint}")
	public Baby create(@RequestBody Baby baby) {
		return service.create(baby);
	}
	
	@DeleteMapping("${delete_endpoint}")
	public String delete(@PathVariable Long id) {
		return service.delete(id);
	}

	@PutMapping("${update_endpoint}")
	public String update(@PathVariable Long id, @RequestBody Baby baby) {
		return service.update(id, baby);
	}

}

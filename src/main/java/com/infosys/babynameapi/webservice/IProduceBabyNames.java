package com.infosys.babynameapi.webservice;

import org.springframework.web.bind.annotation.RestController;
import com.infosys.babynameapi.persistence.domain.Baby;

@RestController
public interface IProduceBabyNames {
	void sendBaby(Baby baby);
}
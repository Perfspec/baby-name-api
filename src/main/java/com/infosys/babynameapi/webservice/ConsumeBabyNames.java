package com.infosys.babynameapi.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.babynameapi.persistence.domain.Baby;

@RestController
@CrossOrigin
public class ConsumeBabyNames implements IConsumeBabyNames {
	
	@Value("${baby_name_generator_ip}")
	private String consumerIP;
	
	@Value("${baby_name_generator_port}")
	private String consumerPort;
	
	@Value("${baby_name_generator_path_for_get}")
	private String consumePath;

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public String selectNameFor(Baby baby) {
		return restTemplate.postForObject(consumerIP+consumerPort+consumePath, baby, String.class);
	}

}

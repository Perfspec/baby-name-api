package com.infosys.babynameapi.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Value("${baby_name_generator_path_part1}")
	private String path1;
	
	@Value("${baby_name_generator_path_part2}")
	private String path2;

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public String selectNameFor(@RequestBody Baby baby) {
		return restTemplate.postForObject(consumerIP+consumerPort
				+path1+baby.getDesiredNameLength().toString()
				+path2+baby.getName(), baby, String.class);
	}
}

package com.infosys.babynameapi.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.babynameapi.persistence.domain.Baby;
import com.infosys.babynameapi.pojo.BabyPojo;

@RestController
@CrossOrigin
public class ProduceBabyNames implements IProduceBabyNames {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendBaby(Baby baby) {
		BabyPojo babyPojo = new BabyPojo(baby);
		
		jmsTemplate.convertAndSend("babyQueue",
				babyPojo);
	}
}

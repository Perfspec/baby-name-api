package com.infosys.babynameapi.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.babynameapi.persistence.domain.Baby;
import com.infosys.babynameapi.rest.IBabyEndpoint;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Integration {
	
	@Value("${bad_name1}")
	private String badName1;
	
	@Value("${bad_name_msg}")
	private String badNameMsg;
	
	@Autowired
	private IBabyEndpoint endpoint;
	
	@Test
	public void findAccountTest() {
		Baby baby = new Baby(8, "Ber");
		endpoint.create(baby);
		assertEquals(baby.getName(), endpoint.find(baby.getId()).get().getName());
	}
	
	@Test
	public void createTest() {
		String initialName = "Ha";
		Baby baby = new Baby(5, initialName);
		assertEquals(baby, endpoint.create(baby).getName().substring(0, initialName.length()));
	}
	
	@Test
	public void createTest2() {
		String initialName = "Ha";
		Baby baby = new Baby(initialName.length(), initialName);
		assertEquals(baby, endpoint.create(baby));
	}
	
	@Test
	public void businessRulesTest() {
		Baby baby = new Baby(badName1.length(), badName1);
		assertEquals(badNameMsg, endpoint.create(baby));
	}
}

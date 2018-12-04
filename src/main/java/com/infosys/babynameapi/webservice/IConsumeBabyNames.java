package com.infosys.babynameapi.webservice;

import com.infosys.babynameapi.persistence.domain.Baby;

public interface IConsumeBabyNames {

	String selectNameFor(Baby baby);

}

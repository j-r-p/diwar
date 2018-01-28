package org.pirate.diwar.dao.impl;

import org.pirate.diwar.dao.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Repository
public class LocationDAOImpl implements LocationDAO {
	
	@Autowired
	RestTemplate restTmpl;
	
	@Autowired
	Gson gson;
	
	final static String webServiceURL = "https://www.walmart.com";

	@Override
	public String fetchLocation(String zip) {
		final String endPointURL = String.format("%s/account/api/location", webServiceURL);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String json = String.format("{\"postalCode\":\"%s\",\"responseGroup\":\"STOREMETA\",\"storeMeta\":true,\"plus\":false}", zip);
		HttpEntity<String> entity = new HttpEntity<String>(json,headers);
		HttpEntity<String> response = restTmpl.exchange(endPointURL, HttpMethod.PUT, entity, String.class,new Object());
		return response.getBody();
	}

}

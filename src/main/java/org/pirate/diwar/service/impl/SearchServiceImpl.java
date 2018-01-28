package org.pirate.diwar.service.impl;

import java.util.List;

import org.pirate.diwar.dao.LocationDAO;
import org.pirate.diwar.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SearchServiceImpl implements SearchService {

	@Autowired
	LocationDAO locl;
	@Autowired
	@Qualifier("zipList")
	List<String> zipList;
	@Override
	public String searchPrice(String itemId) {
		
		return locl.fetchLocation(zipList.get(0));
	}

}

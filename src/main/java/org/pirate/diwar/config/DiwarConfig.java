package org.pirate.diwar.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Configuration
public class DiwarConfig {
	
	
	@Bean
	public RestTemplate getRestClient() {
		RestTemplate restTmpl;
		restTmpl = new RestTemplate();
		return restTmpl;
	}
	
	@Bean
	public Gson getGoogleJson() {
		return new Gson();
	}
	
	@Bean(name="zipList")
	public List<String> zipList(){
		List<String> zip = new ArrayList<>();
		zip.add("85027");
		zip.add("19702");
		return zip;
		
	}

}

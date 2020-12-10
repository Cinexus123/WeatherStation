package com.example.weatherStation.services.impl;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherStation.dto.MainDto;
import com.example.weatherStation.entity.Main;
import com.example.weatherStation.services.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final String URL_API = "https://api.openweathermap.org/data/2.5/weather?q=###,@@@&appid=b7d13264c0cc28c6987c9dd7c5bdb1dc";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${apiKey}")
	private String apiKey;
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	@Override
	public Main getInformation(String country, String town) throws Exception {
		
		MainDto mainDto = restTemplate.getForObject(prepareUrl(country, town), MainDto.class);
		return null;
	}

	private String prepareUrl(String country, String town) throws URISyntaxException {
		
		URL prepareUrl = null;

		try {
			prepareUrl = apiUrlRequest(country, town);

		} catch (MalformedURLException e) {
			logger.info("MalformedURLException " + e.getMessage());
			e.printStackTrace();
		}
		return prepareUrl.toString();
	}

	private URL apiUrlRequest(String country, String town) throws URISyntaxException, MalformedURLException {
		
		String URL_API_change = URL_API.replaceAll("\\###", country).replaceAll("\\$$$", town);
		URIBuilder uriBuilder = new URIBuilder(URL_API_change);
		uriBuilder.addParameter("apiKey", apiKey);
		uriBuilder.addParameter("country", country);
		uriBuilder.addParameter("town", town);
		return uriBuilder.build().toURL();
	}
	
	
	

}

package com.example.weatherStation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherStation.entity.Main;
import com.example.weatherStation.services.WeatherService;

@RestController
public class WeatherController {

	private final WeatherService weatherService;

	@Autowired
	public WeatherController(WeatherService weatherService) {
		super();
		this.weatherService = weatherService;
	}

	@GetMapping("/info/{country}/{town}")
	public ResponseEntity<Main> getAllInformation(@PathVariable("country") String country, @PathVariable("town") String town)
	{
		Main listOfInformation;
		
		
		try
		{
			listOfInformation = weatherService.getInformation(country,town);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Main(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(listOfInformation, HttpStatus.NOT_FOUND);
	}

	
}

package com.example.weatherStation.services;

import com.example.weatherStation.entity.Main;

public interface WeatherService {

	Main getInformation(String country, String town) throws Exception;

	
}

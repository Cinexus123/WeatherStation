package com.example.weatherStation.dto;

import lombok.Data;

@Data
public class MainDto {
	
	private String temp;
	private String feels_like;
	private String temp_min;
	private String temp_max;
	private Long pressure;
	private Long humidity;
	private Long visibility;

}

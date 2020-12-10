package com.example.weatherStation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {

	private String temp;
	private String feels_like;
	private String temp_min;
	private String temp_max;
	private Long pressure;
	private Long humidity;
	private Long visibility;
	
}

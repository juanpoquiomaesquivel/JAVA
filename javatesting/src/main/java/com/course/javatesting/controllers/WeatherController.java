package com.course.javatesting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.javatesting.models.Weather;
import com.course.javatesting.services.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService service;

	@GetMapping("/api/weather")
	public Weather getWeather() {
		return service.getWeather();
	}
}

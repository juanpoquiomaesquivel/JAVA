package com.course.javatesting.services;

import org.springframework.stereotype.Service;

import com.course.javatesting.models.Weather;

@Service
public class WeatherService {

	public Weather getWeather() {
		Weather weather = new Weather();
		weather.setMaxTemp(30);
		weather.setMinTemp(15);
		weather.setStatus("Sunny");
		return weather;
	}
}

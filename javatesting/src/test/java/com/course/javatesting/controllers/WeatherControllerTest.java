package com.course.javatesting.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.course.javatesting.models.Weather;
import com.course.javatesting.services.WeatherService;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

	@InjectMocks
	private WeatherController controller;
	
	@Mock
	private WeatherService service;
	
	@Test
	public void getWeather() { // only test the controller
		Weather weatherMock = new Weather();
		weatherMock.setMaxTemp(10);
		weatherMock.setMinTemp(8);
		weatherMock.setStatus("Cloudy");
		when(service.getWeather()).thenReturn(weatherMock);
		
		Weather result = controller.getWeather();
		
		verify(service, times(1)).getWeather();
	}
}

// https://youtu.be/2S6Mq-ylg3k?t=8224
package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.persistence.model.VehicleReading;
import io.egen.service.ReadingService;

@RestController
public class ReadingController {

	@Autowired
	ReadingService readingService;

	//@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
	@RequestMapping(value = "/readings", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String saveReading(@RequestBody VehicleReading reading) {
		readingService.saveReading(reading);
		return "Success";
	}
	@RequestMapping(value = "/readings", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<VehicleReading> getAllReadings() {
		return readingService.getAllReadings();
	}

}

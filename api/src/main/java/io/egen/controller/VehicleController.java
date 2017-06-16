package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.persistence.model.Vehicle;
import io.egen.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@RequestMapping(value = "/test")
	public String test() {
		return "response";
	}
	
	@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
	@RequestMapping(value = "/vehicles", method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> saveVehicles(@RequestBody List<Vehicle> cars) {
		return vehicleService.saveVehicles(cars);
	}
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(value = "/vehicles", method= RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> findAllVehicles() {
		return vehicleService.findAllVehicles();
	}	
}

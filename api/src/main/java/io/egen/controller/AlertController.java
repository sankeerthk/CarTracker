package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.persistence.model.Alert;
import io.egen.service.AlertService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AlertController {
	
	@Autowired
	AlertService alertService;
	
	@RequestMapping(value = "/allHighAlerts", method= RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> getAllHighAlerts() {
		return alertService.getAllHighAlerts();
	}
	
	@RequestMapping(value = "/allAlerts", method= RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> getAllAlerts() {
		return alertService.getAllAlerts();
	}
	
	@RequestMapping(value = "/alerts/{vin}", method= RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> getAlertsByVin(@PathVariable("vin") String vin) {
		return alertService.getAlertsByVin(vin);
	}

}

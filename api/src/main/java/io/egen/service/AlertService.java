package io.egen.service;

import java.util.List;

import io.egen.persistence.model.Alert;
import io.egen.persistence.model.Vehicle;
import io.egen.persistence.model.VehicleReading;

public interface AlertService {

	void createAlert(Vehicle vehicle,String priority,String message);
	
	void checkAlerts(VehicleReading vachicleReading);

	List<Alert> getAllHighAlerts();

	List<Alert> getAlertsByVin(String vin);

	List<Alert> getAllAlerts();

}

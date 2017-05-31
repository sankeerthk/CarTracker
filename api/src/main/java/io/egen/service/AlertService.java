package io.egen.service;

import io.egen.persistence.model.Vehicle;
import io.egen.persistence.model.VehicleReading;

public interface AlertService {

	void createAlert(Vehicle vehicle,String priority,String message);
	
	void checkAlerts(VehicleReading vachicleReading);

}

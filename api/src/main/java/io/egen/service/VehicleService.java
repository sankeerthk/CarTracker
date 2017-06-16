package io.egen.service;

import java.util.List;

import io.egen.persistence.model.Vehicle;

public interface VehicleService {
	
	List<Vehicle> saveVehicles(List<Vehicle> cars);

	List<Vehicle> findAllVehicles();
	
	Vehicle findByVin(String vin);

}

package io.egen.service;

import java.util.List;

import io.egen.persistence.model.VehicleReading;

public interface ReadingService {

	List<VehicleReading> findCarReading(VehicleReading vachicleReading);

	void saveReading(VehicleReading vachicleReading);

	List<VehicleReading> getAllReadings();

	List<VehicleReading> getReadingsByVehicle(String vin);

}

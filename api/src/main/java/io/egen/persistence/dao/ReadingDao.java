package io.egen.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.egen.persistence.model.Vehicle;
import io.egen.persistence.model.VehicleReading;

public interface ReadingDao extends CrudRepository<VehicleReading, Long> {

	List<VehicleReading> findByReadingId(long readingId);

	List<VehicleReading> findByVin(Vehicle findByVin);

	
}

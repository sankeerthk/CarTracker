package io.egen.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import io.egen.persistence.model.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, String> {

	Vehicle findByVin(String vin);
}

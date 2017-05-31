package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.egen.persistence.dao.VehicleDao;
import io.egen.persistence.model.Vehicle;

@Service("vehicleService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao vehicleDao;

	@Override
	public List<Vehicle> saveVehicles(List<Vehicle> cars) {
		cars.forEach(car -> vehicleDao.save(car));
		return cars;
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return (List<Vehicle>) vehicleDao.findAll();
	}

	@Override
	public Vehicle findByVin(String vin) {
		return vehicleDao.findByVin(vin);
	}
}

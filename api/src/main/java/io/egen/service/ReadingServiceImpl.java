package io.egen.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.egen.persistence.dao.ReadingDao;
import io.egen.persistence.model.VehicleReading;

@Service("readingService")
@Transactional(propagation = Propagation.REQUIRED)
public class ReadingServiceImpl implements ReadingService {
	
	@Autowired
	ReadingDao readingDao;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	AlertService alertService;
	
	@Override
	public List<VehicleReading> findCarReading(VehicleReading vachicleReading) {
		return readingDao.findByReadingId(vachicleReading.getReadingId());
	}

	@Override
	public void saveReading(VehicleReading vachicleReading) {
		readingDao.save(vachicleReading);
		alertService.checkAlerts(vachicleReading);
	}

	@Override
	public List<VehicleReading> getAllReadings() {
		return (List<VehicleReading>) readingDao.findAll();
	}

	@Override
	public List<VehicleReading> getReadingsByVehicle(String vin) {
		return readingDao.findByVin(vehicleService.findByVin(vin));
	}
}

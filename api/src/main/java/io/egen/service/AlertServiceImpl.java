package io.egen.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.egen.persistence.dao.AlertDao;
import io.egen.persistence.model.Alert;
import io.egen.persistence.model.Vehicle;
import io.egen.persistence.model.VehicleReading;

@Service("alertService")
@Transactional(propagation = Propagation.REQUIRED)
public class AlertServiceImpl implements AlertService {
	
	@Autowired
	AlertDao alertDao;
	
	@Autowired
	ReadingService readingService;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	private MessageSource messages;
	
	@Override
	public void createAlert(Vehicle carInfo,String priority,String message) {
		Alert alert= new Alert();
		alert.setVin(carInfo);
		alert.setPriority(priority);
		alert.setMessage(message);
		alertDao.save(alert);
	}

	@Override
	public void checkAlerts(VehicleReading vechicleReading) {
		Vehicle vehicle =vehicleService.findByVin(vechicleReading.getVin().getVin());		
		if(vechicleReading.getEngineRpm() > vehicle.getRedlineRpm()){
			createAlert(vehicle,messages.getMessage("alert.priority.engineRpm",null,null),messages.getMessage("alert.message.rpm", null,null));
		}
		if(vechicleReading.getFuelVolume() < (vehicle.getMaxFuelVolume()*10)/100){
			createAlert(vehicle,messages.getMessage("alert.priority.fuelVolume",null,null),messages.getMessage("alert.message.fuelVolume", null,null));
		}
		if(vechicleReading.getSpeed()>100){
			createAlert(vehicle,messages.getMessage("alert.priority.speed",null,null),messages.getMessage("alert.message.speed", null,null));
		}
		if(vechicleReading.getTires().getFrontLeft()<32 || vechicleReading.getTires().getFrontLeft()>36 || 
				vechicleReading.getTires().getFrontRight()<32 || vechicleReading.getTires().getFrontRight()>36 ||
				vechicleReading.getTires().getRearLeft()<32 || vechicleReading.getTires().getRearLeft()>36 ||
				vechicleReading.getTires().getRearRight()<32 || vechicleReading.getTires().getRearRight()>36){
			createAlert(vehicle,messages.getMessage("alert.priority.tirePressure",null,null),messages.getMessage("alert.message.tirePressure", null,null));
		}
		if(vechicleReading.isEngineCoolantLow() || vechicleReading.isCheckEngineLightOn()){
			createAlert(vehicle,messages.getMessage("alert.priority.coolant.checkEngineLight",null,null),messages.getMessage("alert.message.coolant.checkEngineLight", null,null));
		}
	}

	@Override
	public List<Alert> getAllHighAlerts() {
		return alertDao.findByPriority(messages.getMessage("alert.priority.find", null, null));
	}
	/*@Override
	public List<Alert> getAllHighAlerts() {
		Timestamp currentTimeStamp= new Timestamp(System.currentTimeMillis());
		System.out.println("currentTimeStamp: "+currentTimeStamp);
		Timestamp lessThan2hrsDate = currentTimeStamp;
		lessThan2hrsDate.setHours(lessThan2hrsDate.getHours()-2);
		System.out.println("lessThan2hrsDate: "+lessThan2hrsDate);
		return alertDao.findByPriorityAndTimestampBetween("HIGH",lessThan2hrsDate,currentTimeStamp);
	}*/

	@Override
	public List<Alert> getAlertsByVin(String vin) {
		Vehicle vehicle =vehicleService.findByVin(vin);
		return alertDao.findByVin(vehicle);
	}

	@Override
	public List<Alert> getAllAlerts() {
		return alertDao.findAll();
	}
}

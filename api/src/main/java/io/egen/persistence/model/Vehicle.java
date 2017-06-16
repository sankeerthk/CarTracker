package io.egen.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	private String vin;
	private String make;
	private String model;
	private long year;
	private long redlineRpm;
	private Float maxFuelVolume;
	private Timestamp lastServiceDate;

	public Vehicle() {	}
	
	public Vehicle(String vin) {
		this.vin = vin;
		}
	
	@Id
	@Column(name = "VIN")
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Column(name = "MAKE")
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "YEAR")
	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	@Column(name = "RED_LINE_RPM")
	public long getRedlineRpm() {
		return redlineRpm;
	}

	public void setRedlineRpm(long redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	@Column(name = "MAX_FUEL_VOLUME")
	public Float getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(Float maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	@Column(name = "LAST_SERVICE_DATE")
	public Timestamp getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(Timestamp lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
}

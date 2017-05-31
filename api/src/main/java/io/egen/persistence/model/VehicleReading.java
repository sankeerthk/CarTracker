package io.egen.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="VEHICLE_READING")
public class VehicleReading implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long readingId;
	private Vehicle vin;
	private Float latitude;
	private Float longitude;
	private Timestamp timestamp;
	private Float fuelVolume;
	private long speed;
	private long engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private long engineRpm;
	private Tires tires;
	
	public VehicleReading(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "SEQ_VEHICLE_READING", allocationSize = 1)
	@Column(name="READING_ID")
	public long getReadingId() {
		return readingId;
	}
	public void setReadingId(long readingId) {
		this.readingId = readingId;
	}
	
	@ManyToOne(optional = false,fetch=FetchType.EAGER)
	@JoinColumn(name="VIN")
	public Vehicle getVin() {
		return vin;
	}
	public void setVin(Vehicle vin) {
		this.vin = vin;
	}
	
	@Column(name="LATITUDE")
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
	@Column(name="LONGITUDE")
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	@Column(name="TIME_STAMP")
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Column(name="FUEL_VOLUME")
	public Float getFuelVolume() {
		return fuelVolume;
	}
	public void setFuelVolume(Float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	
	@Column(name="SPEED")
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	@Column(name="ENGINE_HP")
	public long getEngineHp() {
		return engineHp;
	}
	public void setEngineHp(long engineHp) {
		this.engineHp = engineHp;
	}
	
	@Column(name="IS_CHECK_ENGINE_LIGHT_ON")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}
	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
	
	@Column(name="IS_ENGINE_COOLANT_LOW")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}
	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
	
	@Column(name="IS_CRUISE_CONTROL_ON")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}
	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}
	
	@Column(name="ENGINE_RPM")
	public long getEngineRpm() {
		return engineRpm;
	}
	public void setEngineRpm(long engineRpm) {
		this.engineRpm = engineRpm;
	}
	
	@Embedded
	public Tires getTires() {
		return tires;
	}
	public void setTires(Tires tires) {
		this.tires = tires;
	}	
}

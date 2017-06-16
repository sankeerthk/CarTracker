package io.egen.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="ALERT")
public class Alert implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private long alertId;
	private Vehicle vin;
	private Timestamp timestamp;
	private String message;
	private String priority;
	
	public Alert(){
	}

	@Id
	@Column(name="ALERT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "SEQ_ALERT", allocationSize = 1)
	public long getAlertId() {
		return alertId;
	}
	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}
	
	@ManyToOne(optional = false,fetch=FetchType.EAGER)
	@JoinColumn(name="VIN")
	public Vehicle getVin() {
		return vin;
	}
	public void setVin(Vehicle vin) {
		this.vin = vin;
	}

	@Column(name="TIME_STAMP")
	@CreationTimestamp
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name="MESSAGE")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name="PRIORITY")
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
}

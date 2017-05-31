package io.egen.persistence.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Tires {
	
	private int frontLeft;
	private int frontRight;
	private int rearLeft;
	private int rearRight;
	
	@Column(name="FRONT_LEFT")
	public int getFrontLeft() {
		return frontLeft;
	}
	public void setFrontLeft(int frontLeft) {
		this.frontLeft = frontLeft;
	}
	@Column(name="FRONT_RIGHT")
	public int getFrontRight() {
		return frontRight;
	}
	public void setFrontRight(int frontRight) {
		this.frontRight = frontRight;
	}
	
	@Column(name="REAR_LEFT")
	public int getRearLeft() {
		return rearLeft;
	}
	public void setRearLeft(int rearLeft) {
		this.rearLeft = rearLeft;
	}
	@Column(name="REAR_RIGHT")
	public int getRearRight() {
		return rearRight;
	}
	public void setRearRight(int rearRight) {
		this.rearRight = rearRight;
	}
}

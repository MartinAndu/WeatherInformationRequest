package com.challenge.Model;


import com.challenge.Model.Enums.MotionRotationalDirection;

public class Planet {

	private String name;

	private Integer distanceToSun;

	private Position position;

	private static Double initialAngle;

	private Double angularVelocity;

	private MotionRotationalDirection motionRotationalDirection;

	public Planet(String name, Integer distanceToSun, MotionRotationalDirection motionRotationalDirection, Double initialAngle, Double angularVelocity) {
		this.name = name;
		this.distanceToSun = distanceToSun;
		this.initialAngle = initialAngle;
		this.motionRotationalDirection = motionRotationalDirection;
		this.angularVelocity = angularVelocity;
	}

	public Position getPosition(int day) {
		// The convention concerning languages ( Java in this case) , indicates that
		// 0 radians is to the right, therefore, increasing angles will
		Double angle = Math.toRadians(this.initialAngle - this.motionRotationalDirection.getValue() * angularVelocity * day);
		Double coordinateX = Math.cos(angle) * this.distanceToSun;
		Double coordinateY = Math.sin(angle) * this.distanceToSun;
		return new Position(coordinateX, coordinateY);
	}

} 
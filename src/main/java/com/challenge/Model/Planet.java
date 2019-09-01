package com.challenge.Model;


import com.challenge.Model.Enums.MotionRotationalDirection;

public class Planet {

	private String name;

	private Double distanceToSun;

	private Position position;

	private Double initialAngle;

	private Double angularVelocity;

	private MotionRotationalDirection motionRotationalDirection;

	public Planet(String name, double distanceToSun, MotionRotationalDirection motionRotationalDirection, double initialAngle, double angularVelocity) {
		this.name = name;
		this.distanceToSun = distanceToSun;
		this.initialAngle = initialAngle;
		this.motionRotationalDirection = motionRotationalDirection;
		this.angularVelocity = angularVelocity;
	}

	public Position getPosition(int day) {
		double angle = Math.toRadians(this.initialAngle + angularVelocity * day * this.motionRotationalDirection.getValue());
		double coordinateX = Math.cos(angle) * this.distanceToSun;
		double coordinateY = Math.sin(angle) * this.distanceToSun;
		return new Position(coordinateX, coordinateY);
	}

} 
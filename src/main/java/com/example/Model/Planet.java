package com.example.Model;


import com.example.Model.Enums.MotionRotationalDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Planet {

	private String name;

	private double distanceToSun;

	private Position position;

	private double initialAngle;

	private double angularVelocity;

	private MotionRotationalDirection motionRotationalDirection;

	public Planet(String name, double distanceToSun, MotionRotationalDirection motionRotationalDirection, double initialAngle, double angularVelocity) {
		this.name = name;
		this.distanceToSun = distanceToSun;
		this.initialAngle = initialAngle;
		this.motionRotationalDirection = motionRotationalDirection;
		this.angularVelocity = angularVelocity;
	}

	public Position getPosition(int day) {
		double angle = Math.toRadians(this.initialAngle + angularVelocity * day);
		double coordinateX = Math.cos(angle) * this.distanceToSun;
		double coordinateY = Math.sin(angle) * this.distanceToSun;
		return new Position(coordinateX, coordinateY);
	}

} 
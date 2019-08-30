package com.example.Model;

import org.springframework.stereotype.Component;

public class Position {


	private double coordinateX;
	
	private double coordinateY;

	public Position(double coordinateX, double coordinateY) {
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
	}

	public double getCoordinateX() {
		return this.coordinateX;
	}

	public double getCoordinateY() {
		return this.coordinateY;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

}
package com.challenge.Model;

public class Position {


	private Double coordinateX;
	
	private Double coordinateY;

	public Position(Double coordinateX, Double coordinateY) {
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
	}

	public Double getCoordinateX() {
		return this.coordinateX;
	}

	public Double getCoordinateY() {
		return this.coordinateY;
	}

	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}

}
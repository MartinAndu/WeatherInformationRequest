package com.example.Model.Enums;



public enum MotionRotationalDirection {
	CLOCKWISE(1),COUNTERCLOCKWISE(-1);

	private final int value;

	MotionRotationalDirection(int value) {
		this.value = value;
	}
/*
	public static Optional<MotionRotationalDirection> valueOf(int value) {
		return Arrays.stream(values())
					.filter( orientation -> orientation.value == value)
					.findFirst();
	}*/
}
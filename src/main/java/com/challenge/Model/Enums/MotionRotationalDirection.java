package com.challenge.Model.Enums;


import java.util.HashMap;
import java.util.Map;

public enum MotionRotationalDirection {
	CLOCKWISE(1),
	COUNTERCLOCKWISE(-1);


	/*
		Initialization on demand holder idiom ( lazy-loaded singleton pattern)
		To get a value from enum. The JVM doesn't initialize LazyHolder until
		is executed by getValue();
	 */
	private static class LazyHolder {
		 static Map<Integer, MotionRotationalDirection> mapDirection = new HashMap();
	}

	private final Integer value;

	MotionRotationalDirection(Integer value) {
		this.value = value;
		LazyHolder.mapDirection.put(value, this);
	}

	public Integer getValue() {
		return this.value;
	}

}
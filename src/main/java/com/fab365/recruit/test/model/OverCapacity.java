package com.fab365.recruit.test.model;

public class OverCapacity extends Payment {

	private int overCapacity;

	public OverCapacity() {
	}

	public int getOverCapacity() {
		return overCapacity;
	}

	@Override
	public OverCapacity overCapacityCalculate(int usageDataInMegabyte, Fee fee) {
		return this;
	}
}

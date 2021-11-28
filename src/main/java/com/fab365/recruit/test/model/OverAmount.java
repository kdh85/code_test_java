package com.fab365.recruit.test.model;

public class OverAmount extends Payment{

	private int overAmount;

	public OverAmount() {
	}

	public int getOverAmount() {
		return overAmount;
	}

	@Override
	public OverAmount overAmountCalculate(int overCapacity) {
		return this;
	}
}

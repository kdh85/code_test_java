package com.fab365.recruit.test.model;

public enum BasicOverCost {
	BASIC_TYPE(20,1);

	private final int basicAmount;
	private final int basicCapacity;

	BasicOverCost(int basicAmount, int basicCapacity) {
		this.basicAmount = basicAmount;
		this.basicCapacity = basicCapacity;
	}

	public int calculateAmount(int overCapacity) {
		return overCapacity * this.basicAmount / this.basicCapacity ;
	}

	public int getBasicAmount() {
		return basicAmount;
	}

	public int getBasicCapacity() {
		return basicCapacity;
	}
}

package com.fab365.recruit.test.model;

import static com.fab365.recruit.test.model.OverCapacity.*;

import java.util.Objects;

public class OverAmount extends Payment {

	private int overAmount;

	public OverAmount() {
	}

	public int getOverAmount() {
		return overAmount;
	}

	@Override
	public OverAmount overAmountCalculate(int overCapacity, BasicOverCost basicOverCost) {
		validationCapacity(overCapacity);
		this.overAmount = basicOverCost.calculateAmount(overCapacity);
		return this;
	}

	private void validationCapacity(int overCapacity) {
		if(overCapacity < MIN_OVER_CAPACITY_VALUE) {
			throw new IllegalArgumentException(ERROR_MIN_OVER_CAPACITY_VALUE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		OverAmount that = (OverAmount)o;
		return overAmount == that.overAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(overAmount);
	}

	@Override
	public String toString() {
		return "OverAmount{" +
			   "overAmount=" + overAmount +
			   '}';
	}
}

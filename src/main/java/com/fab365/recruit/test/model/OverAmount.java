package com.fab365.recruit.test.model;

import java.util.Objects;

public class OverAmount extends Payment {

	private final int overAmount;

	private OverAmount(int overAmount) {
		this.overAmount = overAmount;
	}

	public static OverAmount from(int overAmount) {
		return new OverAmount(overAmount);
	}

	public int getOverAmount() {
		return overAmount;
	}

	@Override
	public TotalUserAmount totalAmountCalculate(Fee fee) {
		return TotalUserAmount.from(fee.getAmount() + overAmount);
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

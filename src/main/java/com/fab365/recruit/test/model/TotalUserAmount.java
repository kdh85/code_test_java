package com.fab365.recruit.test.model;

import java.util.Objects;

public class TotalUserAmount extends Payment {

	private static final int DEFAULT_TOTAL_VALUE = 0;

	private final int totalAmount;

	private TotalUserAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public static TotalUserAmount createDefaultTotal() {
		return new TotalUserAmount(DEFAULT_TOTAL_VALUE);
	}

	public static TotalUserAmount from(int totalAmount) {
		return new TotalUserAmount(totalAmount);
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public TotalUserAmount compareTotalAmount(TotalUserAmount targetAmount) {

		if (isGreaterThan(targetAmount) || isSameToDefault()) {
			return targetAmount;
		}

		return this;
	}

	private boolean isSameToDefault() {
		return this.totalAmount == DEFAULT_TOTAL_VALUE;
	}

	private boolean isGreaterThan(TotalUserAmount targetAmount) {
		return this.totalAmount > targetAmount.totalAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TotalUserAmount that = (TotalUserAmount)o;
		return totalAmount == that.totalAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalAmount);
	}

	@Override
	public String toString() {
		return "TotalUserAmount{" +
			   "totalAmount=" + totalAmount +
			   '}';
	}
}

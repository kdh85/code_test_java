package com.fab365.recruit.test.model;

import java.util.Objects;

public class TotalUserAmount extends Payment {

	private static final int DEFAULT_TOTAL_VALUE = 0;

	private int totalAmount;

	public TotalUserAmount() {
		this(DEFAULT_TOTAL_VALUE);
	}

	public TotalUserAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public TotalUserAmount compareTotalAmount(TotalUserAmount beforeTotal){

		if(isSameToDefault(beforeTotal)){
			return this;
		}

		if(isGreaterThan(beforeTotal)){
			return beforeTotal;
		}

		return this;
	}

	private boolean isSameToDefault(TotalUserAmount beforeTotal) {
		return beforeTotal.totalAmount == DEFAULT_TOTAL_VALUE;
	}

	private boolean isGreaterThan(TotalUserAmount beforeTotal) {
		return this.totalAmount > beforeTotal.totalAmount;
	}

	@Override
	public TotalUserAmount totalAmountCalculate(int overAmount, Fee fee) {
		this.totalAmount = fee.getAmount() + overAmount;
		return this;
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
